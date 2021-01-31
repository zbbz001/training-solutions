package lambdaprimitives;

import java.util.*;

public class SportGadgetStore {

    List<Product> productList = new ArrayList<>();

    public SportGadgetStore(List<Product> productList) {
        this.productList = productList;
    }

    public int getNumberOfProducts() {
        return productList.stream()
                .mapToInt(Product::getPieces)
                .sum();
    }

    public double getAveragePrice() {
        OptionalDouble avg = productList.stream()
                .mapToDouble(Product::getPrice)
                .average();

        return avg.isPresent() ? avg.getAsDouble() : 0;
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stat = productList.stream()
                .filter(product -> product.getPrice() > minPrice)
                .mapToInt(Product::getPieces)
                .summaryStatistics();

        if (stat.getCount() > 0) {
            StringBuilder sb = new StringBuilder("Összesen ")
                    .append(stat.getCount())
                    .append(" féle termék, amelyekből minimum ")
                    .append(stat.getMin())
                    .append(" db, maximum ")
                    .append(stat.getMax())
                    .append(" db, összesen ")
                    .append(stat.getSum())
                    .append(" db van.");
            return sb.toString();
        }
        return "Nincs ilyen termék.";

    }


}
