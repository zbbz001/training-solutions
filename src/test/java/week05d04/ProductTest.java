package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void productConvertTest() {
        assertEquals(3000.0, new Product(3000, CurrencyType.HUF).convertPrice(CurrencyType.HUF));
        assertEquals(10.0, new Product(3000, CurrencyType.HUF).convertPrice(CurrencyType.USD));
        assertEquals(10.0, new Product(3000, CurrencyType.USD).convertPrice(CurrencyType.HUF));
    }

    @Test
    public void productCurrencyTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->new Product(211, null));
        assertEquals("The currency is cannot be null.", ex.getMessage());
    }
}