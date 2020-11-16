package week04;

import org.junit.jupiter.api.Test;
import stringscanner.StringScanner;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

    @Test
    public void testChangeFirstname() {
        NameChanger nc = new NameChanger("Bátor Vitéz");

        nc.changeFirstName("Indián");
        assertEquals("Bátor Indián", nc.getFullName());
    }

    @Test
    public void testNameChangerEmptyArg() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid Name: ", ex.getMessage());
    }

}