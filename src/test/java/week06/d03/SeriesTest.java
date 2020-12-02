package week06.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    public void testSeries() {
        Series series = new Series();
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11);
        assertEquals(ListType.GROWING, series.calculateSeriesType(numberList));

        series = new Series();
        numberList = Arrays.asList(1, 2, 0, 4, 1, 6, 7);
        assertEquals(ListType.OTHER, series.calculateSeriesType(numberList));

        series = new Series();
        numberList = Arrays.asList(99, 88, 77, 66, 55, 14);
        assertEquals(ListType.DECREASING, series.calculateSeriesType(numberList));
    }

    @Test
    public void testSeriesEmptyList() {
        Series series = new Series();
        List<Integer> numberList = new ArrayList<>();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(numberList));
        assertEquals("The number's list is null or contains few numbers.", ex.getMessage());
    }
}