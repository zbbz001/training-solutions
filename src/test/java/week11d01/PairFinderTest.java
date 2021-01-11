package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairsTest() {
        PairFinder pairFinder = new PairFinder();

        assertEquals(3, pairFinder.findPairs(new int[]{1, 1, 3, 6, 8, 1, 3, 1}));

    }
}