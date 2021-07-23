package gameboj.component.sound;

import static gameboj.bits.Bits.*;
import static gameboj.component.sound.Apu.ChannelType;

public class Square extends SoundChannel{
    private final static int[] DUTY_PATTERN = new int[] {
            0b00000001,
            0b10000001,
            0b10000111,
            0b01111110,
    };

    protected final VolumeEnvelope envelope;

    protected int wavePosition;
    protected int freqDiv;
    protected int duty;

    public Square(ChannelType type) {
        super(type);
        envelope = new VolumeEnvelope();
    }

    public Square() {
        this(ChannelType.SQUARE_B);
    }

    @Override
    public void write(int address, int data) {
        if (regStartAddress <= address && address < regEndAddress) {
            Reg reg = Reg.values()[address - regStartAddress];
            super.write(address, data);
            switch (reg) {
                case NR1:
                    length.setLength(64 - clip(6, data));
                    break;
                case NR2:
                    envelope.updateEnvelope(data);
                    dacEnabled = extract(data, 3, 5) != 0;
                    channelEnabled &= dacEnabled;
                default:
            }
        }
    }

    @Override
    public int clock() {
        envelope.clock();
        return reallyClock();
    }

    protected int reallyClock() {
        if (!(updateLength() && dacEnabled)) return 0;

        if (--freqDiv == 0) {
            freqDiv = frequency() * 4;
            duty = test(DUTY_PATTERN[dutyPattern()], wavePosition) ? 1 : 0;
            wavePosition = (wavePosition + 1) % 8;
        }
        return duty * envelope.getVolume();
    }

    @Override
    protected void trigger() {
        freqDiv = 1;
        wavePosition = 0;
        envelope.trigger();
    }

    @Override
    protected void start() {
        wavePosition = 0;
        length.start();
        envelope.start();
    }

    private int dutyPattern() { return regFile.get(Reg.NR1) >> 6; }

    protected int getFrequency() {
        int lsb = regFile.get(Reg.NR3);
        int msb = clip(3, regFile.get(Reg.NR4));
        return make16(msb, lsb);
    }
}
