package gameboj.component.apu;

public interface SoundOutput {
    record AudioSample(byte left, byte right) {
    }

    void start();

    void stop();

    void play(AudioSample sample);
}