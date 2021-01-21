package week12d01;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {
    private int weight;
    private int price;

    public Product(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return (int) (((double) price / weight) - ((double) o.getPrice() / o.getWeight()));
    }
}
