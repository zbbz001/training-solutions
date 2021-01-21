package week12d01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GoodsPacker {

    public int packGoods(int[][] types, int capacity) {
        int value = 0;
        List<Product> products = new ArrayList<>();

        for (int[] item : types) {
            products.add(new Product(item[0], item[1]));
        }

        Collections.sort(products);
        Collections.reverse(products);

        int weight = 0;

        for (Product product : products) {
            while (weight + product.getWeight() <= capacity) {
                weight += product.getWeight();
                value += product.getPrice();
            }
        }

        return value;
    }
}
