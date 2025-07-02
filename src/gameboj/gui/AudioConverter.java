package gameboj.gui;

import gameboj.component.apu.SoundOutput;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static gameboj.GameBoy.CLOCK_FREQ;

public final class AudioConverter implements SoundOutput {
    private static final int SAMPLE_RATE = 44100;
    private static final int BUFFER_SIZE = 1024;
    private static final AudioFormat FORMAT = new AudioFormat(
            AudioFormat.Encoding.PCM_UNSIGNED,
            SAMPLE_RATE,
            8,
            2,
            2,
            SAMPLE_RATE,
            false
    );
    private final static byte[] buffer = new byte[BUFFER_SIZE];
    private static final int AUDIO_DIV = (int) (CLOCK_FREQ / FORMAT.getSampleRate());

    private SourceDataLine line;
    private final BlockingQueue<AudioSample> queue = new LinkedBlockingQueue<>();
    private Thread audioThread;
    private volatile boolean running;
    private int tick;

    @Override
    public void start() {
        if (line != null) {
            return;
        }

        try {
            line = AudioSystem.getSourceDataLine(FORMAT);
            line.open(FORMAT, BUFFER_SIZE);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        line.start();
        running = true;
        audioThread = new Thread(this::audioLoop, "AudioThread");
        audioThread.start();
    }

    @Override
    public void stop() {
        if (line == null) {
            return;
        }
        running = false;
        if (audioThread != null) {
            audioThread.interrupt();
            try {
                audioThread.join();
            } catch (InterruptedException ignored) {
            }
            audioThread = null;
        }
        line.drain();
        line.stop();
        line = null;
        queue.clear();
    }

    @Override
    public void play(AudioSample sample) {
        if (tick++ != 0) {
            tick %= AUDIO_DIV;
            return;
        }
        queue.add(sample);
    }

    private void audioLoop() {
        int i = 0;
        try {
            while (running) {
                AudioSample sample = queue.take();
                buffer[i++] = sample.left();
                buffer[i++] = sample.right();
                if (i == BUFFER_SIZE) {
                    line.write(buffer, 0, BUFFER_SIZE);
                    i = 0;
                }
            }
        } catch (InterruptedException ignored) {
        }

        if (i > 0 && line != null) {
            line.write(buffer, 0, i);
        }
    }
}
