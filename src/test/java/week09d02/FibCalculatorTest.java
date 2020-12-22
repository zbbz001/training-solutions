package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {

    @Test
    public void bibCalculatorTest() {
        FibCalculator fibCalc = new FibCalculator();
        assertEquals(10, fibCalc.sumEvens(10));
    }
}