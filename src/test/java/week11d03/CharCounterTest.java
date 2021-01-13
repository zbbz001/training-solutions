package week11d03;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    public void CharCounterTest() {
        CharCounter cc = new CharCounter();
        assertEquals(2, cc.countChars(new String[]{"aabc", "aacb", "cvfaa", "acadea"}));
    }
}