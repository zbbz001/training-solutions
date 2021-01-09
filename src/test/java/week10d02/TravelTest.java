package week10d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void traveltest() {
        Travel travel = new Travel();
        assertEquals(12, travel.getStopWithMax(Travel.class.getResourceAsStream("/utasadat.txt")));
    }

}