package week12d03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AgeSorterTest {

    @Test
    public void ageSorterTest() {
        AgeSorter as = new AgeSorter();

        assertEquals("[1, 2, 2, 2, 6, 7, 11, 15, 21, 33, 81]", Arrays.toString(as.sortAges(new int[]{1, 33, 15, 7, 2, 11, 2, 6, 2, 81, 21})));
    }
}