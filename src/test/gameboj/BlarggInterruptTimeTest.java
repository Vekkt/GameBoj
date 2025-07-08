package test.gameboj;

import gameboj.component.cartridge.Cartridge;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.gameboj.RunTestRom.TEST_SUCCESS;
import static test.gameboj.RunTestRom.runTestRom;

public class BlarggInterruptTimeTest {
    @Test
    void instr_timing() throws IOException {
        File romFile = new File("src/test/ressources/roms/instr_timing/instr_timing.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }
}
