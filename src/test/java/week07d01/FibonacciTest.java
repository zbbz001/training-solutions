package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    public void testFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        assertEquals(0, fibonacci.fib(0));
        assertEquals(1, fibonacci.fib(1));
        assertEquals(1, fibonacci.fib(2));
        assertEquals(2, fibonacci.fib(3));
        assertEquals(3, fibonacci.fib(4));
        assertEquals(5, fibonacci.fib(5));
        assertEquals(8, fibonacci.fib(6));

    }
}