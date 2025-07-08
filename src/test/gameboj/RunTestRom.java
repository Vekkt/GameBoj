package test.gameboj;

import gameboj.GameBoy;
import gameboj.component.cartridge.Cartridge;

public class RunTestRom {
    public final static int TEST_SUCCESS = 1;
    public final static int TEST_FAIL = 2;
    private static String memoryOutput;
    private static int outputPointer;

    public static int runTestRom(Cartridge testRom){
        memoryOutput = "";
        outputPointer = 0xA004;

        GameBoy gb = new GameBoy(testRom);

        DebugComponent debugger = new DebugComponent();
        gb.getBus().attach(debugger);

        long start = System.nanoTime();
        while (debugger.getTestStatus() == 0 && getTestStatusFromMemory(gb) == 0) {
            long now = System.nanoTime();
            gb.runUntil((long) ((now - start) * GameBoy.CLOCK_NANO_FREQ));
        }

        return debugger.getTestStatus() | getTestStatusFromMemory(gb);
    }

    private static void read_memory(GameBoy gb) {
        StringBuilder sb = new StringBuilder(memoryOutput);
        char c;
        while ((c = (char) gb.getBus().read(outputPointer)) != 0 && c != 0xFF) {
            sb.append(c);
            System.out.print(c);
            outputPointer++;
        }
        memoryOutput = sb.toString();
    }

    private static int getTestStatusFromMemory(GameBoy gb) {
        read_memory(gb);
        if (memoryOutput.contains("Passed"))
            return TEST_SUCCESS;
        else if (memoryOutput.contains("Failed"))
            return TEST_FAIL;
        else
            return 0;
    }
}
