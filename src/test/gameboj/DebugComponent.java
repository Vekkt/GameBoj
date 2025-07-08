package test.gameboj;

import gameboj.AddressMap;
import gameboj.component.Component;

public final class DebugComponent implements Component {
    private String bufferString = "";

    @Override
    public int read(int address) {
        return NO_DATA;
    }

    @Override
    public void write(int address, int data) {
        if (address == AddressMap.REG_SB) {
            bufferString += (char) data;
            System.out.print((char) data);
        }
    }

    public int getTestStatus() {
        if (bufferString.contains("Passed"))
            return 1;
        if (bufferString.contains("Failed"))
            return 2;
        return 0;
    }
}
