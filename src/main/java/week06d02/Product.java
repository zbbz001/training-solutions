package week06d02;

public class Product {
    private String name;
    private int price;
    private Category category;

    public Product(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
