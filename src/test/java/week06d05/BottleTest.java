package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    public void testBootle() {
        Bottle bootle = Bottle.of(BootleType.PET_BOTTLE);
        bootle.fill(100);
        assertEquals(100, bootle.getFilledUnit());

        bootle.fill(100);
        assertEquals(200, bootle.getFilledUnit());
    }

    @Test
    public void testBootleOverFill() {
        Bottle bootle = Bottle.of(BootleType.PET_BOTTLE);
        bootle.fill(100);
        assertEquals(100, bootle.getFilledUnit());

        Exception ex = assertThrows(RuntimeException.class, () -> bootle.fill(1000));
        assertEquals("The bottle is full!", ex.getMessage());
    }


}