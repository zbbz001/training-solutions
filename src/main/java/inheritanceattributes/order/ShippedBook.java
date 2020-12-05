package inheritanceattributes.order;

import inheritanceattributes.book.Book;

public class ShippedBook extends Book {
    private int shippingCost;

    public ShippedBook(String title, int price, int shippingCost) {
        super(title, price);
        this.shippingCost = shippingCost;
    }

    public int order(int pieces) {
        return pieces * price + shippingCost;
    }

    @Override
    public String toString() {
        return super.getTitle() + ":" + price + " - " + shippingCost;
    }
}
