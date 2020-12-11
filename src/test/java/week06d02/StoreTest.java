package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    public void testStore() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("first aid", 11, Category.OTHER));
        productList.add(new Product("frozen bean", 10, Category.FROZEN));
        productList.add(new Product("ice cream", 2, Category.FROZEN));
        productList.add(new Product("chees", 54, Category.DAIRY));
        productList.add(new Product("milk", 61, Category.DAIRY));
        productList.add(new Product("cottage", 21, Category.DAIRY));
        productList.add(new Product("bread", 11, Category.BAKEDGOODS));
        productList.add(new Product("cake", 19, Category.BAKEDGOODS));
        productList.add(new Product("croissant", 25, Category.BAKEDGOODS));
        productList.add(new Product("buns", 11, Category.BAKEDGOODS));

        Store store = new Store(productList);

        assertEquals("[FROZEN: 2, DAIRY: 3, BAKEDGOODS: 4, OTHER: 1]", store.getProductByCategory().toString());
    }
}