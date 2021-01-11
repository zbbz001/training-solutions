package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books == null) {
            throw new NullPointerException("The list of books cannot be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }

        Object book = books.get(0);

        if (!(book instanceof Book)) {
            throw new ClassCastException("Not a book");
        }

        return (Book) book;
    }
}
