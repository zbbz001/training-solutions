package ioconvert.products;

import java.io.*;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream outputStream, List<Product> productList) {

        try (PrintStream stream = new PrintStream(outputStream)) {
            for (Product product : productList) {
                stream.print(product.getName());
                stream.print(";");
                stream.println(product.getPrice());
            }
        }
    }
}
