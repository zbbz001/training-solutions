package week06.d01;

import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    public void testSumNumbersInText() {
        SeparatedSum separatedSum = new SeparatedSum();

        assertEquals("sum of positive numbers: 58.7, sum of negative numbers: -15.3 number of zeros: 2",
                separatedSum.sum("12,4;5,3;-3,0;-5,3;0;0;32,0;-5,0;5;4;-2"));

        assertEquals("sum of positive numbers: 0.0, sum of negative numbers: 0.0 number of zeros: 4",
                separatedSum.sum("0;0;0;0"));
    }

    @Test
    public void testSumNumbersFromBlankText() {
        SeparatedSum separatedSum = new SeparatedSum();

        Exception ex = assertThrows(IllegalArgumentException.class, ()->separatedSum.sum(""));
        assertEquals("The text that contains numbers cannot be null or empty.", ex.getMessage());
    }
}