package test.gameboj;

import gameboj.component.cartridge.Cartridge;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.gameboj.RunTestRom.TEST_SUCCESS;
import static test.gameboj.RunTestRom.runTestRom;

public class BlarggCpuInstrsTest {
    @Test
    void cpu_instrs_01() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/01-special.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_02() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/02-interrupts.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_03() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/03-op sp,hl.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_04() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/04-op r,imm.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_05() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/05-op rp.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_06() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/06-ld r,r.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_07() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/07-jr,jp,call,ret,rst.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_08() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/08-misc instrs.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_09() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/09-op r,r.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_10() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/10-bit ops.gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }

    @Test
    void cpu_instrs_11() throws IOException {
        File romFile = new File("src/test/ressources/roms/cpu_instrs/individual/11-op a,(hl).gb");
        Cartridge cpu_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(cpu_rom), TEST_SUCCESS);
    }
}
