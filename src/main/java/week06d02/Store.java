package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList;
    List<CategoryQuantity> categoryQuantityList;

    public List<CategoryQuantity> getProductByCategory() {
        initQuantity();

        for (Product product : productList) {
            addQuantity(product);
        }

        return categoryQuantityList;
    }

    private void addQuantity(Product product) {
        for (CategoryQuantity categoryQuantity : categoryQuantityList) {
            if (product.getCategory() == categoryQuantity.getCategory()) {
                categoryQuantity.increasingQuantity();
            }
        }
    }

    private void addToCategoryQuantityList(Category category) {
        for (CategoryQuantity categoryQuantity : categoryQuantityList) {
            if (category == categoryQuantity.getCategory()) {
                return;
            }
        }

        categoryQuantityList.add(new CategoryQuantity(category));
    }

    private void initQuantity() {
        categoryQuantityList = new ArrayList<>();

        for (Category category : Category.values()) {
            addToCategoryQuantityList(category);
        }
    }

    public Store(List<Product> productList) {
        if (productList == null || productList.size() == 0) {
            throw new IllegalArgumentException("The list of products cannot be null or empty.");
        }

        this.productList = productList;
    }

}
