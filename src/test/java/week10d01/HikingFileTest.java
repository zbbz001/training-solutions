package week10d01;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    public void testHikingCalc() {
        InputStream inputStream = HikingFile.class.getResourceAsStream("log.txt");

        HikingFile hikingFile = new HikingFile();
        ElevationCalculator ec = hikingFile.getElevation(inputStream);

        assertEquals(60, ec.getUp());
        assertEquals(360, ec.getDown());
    }

}