package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream outputStream, List<String> list) {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {
            for (String element : list) {
                outputStreamWriter.write(element + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file.");
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        List<String> shoppingList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                shoppingList.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }

        return shoppingList;
    }
}
