package classsctructureintegrate;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void increasePrice(int changes) {
        this.price += changes;
    }

    public void decreasePrice(int changes) {
        this.price += changes;
    }
}
