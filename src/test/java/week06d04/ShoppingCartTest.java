package week06d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week06d04.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart shoppingCart;

    @BeforeEach
    void init() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addItem("first aid box", 1);
        shoppingCart.addItem("Rubik's Cube", 1);
        shoppingCart.addItem("humor", 33);
    }

    @Test
    public void testShoppingCartAddNewItem() {
        assertEquals(3, shoppingCart.getShoppingChart().size());

        shoppingCart.addItem("Norwegian Blue", 1);
        assertEquals(4, shoppingCart.getShoppingChart().size());
        assertEquals(1, shoppingCart.getItem("Norwegian Blue"));
    }

    @Test
    public void testShoppingCartAddNewItemGetQuantity() {
        shoppingCart.addItem("first aid box", 3);

        assertEquals(4, shoppingCart.getItem("first aid box"));
    }

    @Test
    public void testShoppingCartGetQuantityNotInCart() {
        assertEquals(0, shoppingCart.getItem("big green cow"));
    }

    @Test
    public void testShoppingCartAddNewItemWithoutName() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->shoppingCart.addItem("", 2));

        assertEquals("Item name's cannot be null or empty.", ex.getMessage());
    }
}