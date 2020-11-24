package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {

    @Test
    public void testChangeLetter() {
        ChangeLetter cl = new ChangeLetter();
        String str = "The quick brown fox jumps over the lazy dog";

        assertEquals("Th* q**ck br*wn f*x j*mps *v*r th* l*zy d*g", cl.changeVowels(str));
    }

    @Test
    public void testEmptyString() {
        ChangeLetter cl = new ChangeLetter();
        String str = "";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> cl.changeVowels(str));
        assertEquals("The parameter cannot be an empty string or null.", ex.getMessage());
    }
}