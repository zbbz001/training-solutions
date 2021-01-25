package lambdastreams.bookstore;

public class Book {
    private String Name;
    private int year;
    private int price;
    private int quantity;

    public Book(String name, int year, int price, int quantity) {
        Name = name;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public int getYearOfPublish() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
