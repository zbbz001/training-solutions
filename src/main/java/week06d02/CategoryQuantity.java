package week06d02;

public class CategoryQuantity {

    private int numOfProducts;
    private Category category;

    public void increasingQuantity() {
        numOfProducts++;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category + ": " + numOfProducts;
    }

    public CategoryQuantity(Category category) {
        this.category = category;
    }
}
