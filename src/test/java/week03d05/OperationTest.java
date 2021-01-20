package week03d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    public void testGetResult() {
        Operation operation = new Operation("11+22");

        assertEquals(33, operation.getResult());
    }
}
