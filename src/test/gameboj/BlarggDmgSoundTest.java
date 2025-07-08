package test.gameboj;

import gameboj.component.cartridge.Cartridge;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.gameboj.RunTestRom.TEST_SUCCESS;
import static test.gameboj.RunTestRom.runTestRom;


public class BlarggDmgSoundTest {
    @Test
    void dmg_sound_01() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/01-registers.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_02() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/02-len ctr.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_03() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/03-trigger.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_04() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/04-sweep.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_05() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/05-sweep details.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_06() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/06-overflow on trigger.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_07() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/07-len sweep period sync.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_08() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/08-len ctr during power.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_09() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/09-wave read while on.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_10() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/10-wave trigger while on.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_11() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/11-regs after power.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }

    @Test
    void dmg_sound_12() throws IOException {
        File romFile = new File("src/test/ressources/roms/dmg_sound/rom_singles/12-wave write while on.gb");
        Cartridge sound_rom = Cartridge.ofFile(romFile);
        assertEquals(runTestRom(sound_rom), TEST_SUCCESS);
    }
}