package test.gameboj;

import gameboj.component.cartridge.Cartridge;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.gameboj.RunTestRom.TEST_SUCCESS;
import static test.gameboj.RunTestRom.runTestRom;

public class BlarggMemTimingTest {
    @Test
    void mem_timing_01() throws IOException {
        File romFile = new File("src/test/ressources/roms/mem_timing/individual/01-read_timing.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void mem_timing_02() throws IOException {
        File romFile = new File("src/test/ressources/roms/mem_timing/individual/02-write_timing.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void mem_timing_03() throws IOException {
        File romFile = new File("src/test/ressources/roms/mem_timing/individual/03-modify_timing.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }
}
