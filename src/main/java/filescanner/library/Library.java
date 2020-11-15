package filescanner.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/books.csv"))) {
            scanner.useDelimiter(";|(\r\n)");

            while(scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(";");
                books.add(new Book(line[0], line[1], line[2], Integer.parseInt(line[3])));
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
