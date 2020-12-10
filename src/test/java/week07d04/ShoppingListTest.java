package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {
    ShoppingList sl = new ShoppingList();

    @Test
    public void ShoppingListTest() throws Exception {
        assertEquals(193299, sl.calculateSum("C:/training/training-solutions/shoppinglist.txt"));
    }

    @Test
    public void ShoppingListNoFilePathTest() {
        Exception ex = assertThrows(IllegalStateException.class, () -> sl.calculateSum(""));
        assertEquals("Can not read file", ex.getMessage());
    }

    @Test
    public void ShoppingListWrongLineFormatTest() {
        Exception ex = assertThrows(Exception.class, () -> sl.calculateSum("C:/training/training-solutions/shoppinglist.txt"));
        assertEquals("Incorrect line format: Beer;0", ex.getMessage());
    }
}