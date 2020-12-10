package week07d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShoppingList {

    public long calculateSum(String path) throws Exception {
        Path file = Path.of(path);
        long sum = 0;

        try {
            List<String> shoppingList = Files.readAllLines(file);
            for (String listRow : shoppingList) {
                sum += calculateSubTotal(listRow);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        return sum;
    }

    private long calculateSubTotal(String listRow) throws Exception {
        String[] arrOfRow = listRow.split(";");

        if (arrOfRow.length == 3) {
            return Long.parseLong(arrOfRow[1]) * Long.parseLong(arrOfRow[2]);
        }

        throw new Exception("Incorrect row format: " + listRow);
    }
}
