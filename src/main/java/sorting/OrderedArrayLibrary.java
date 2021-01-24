package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {
    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] sortedBooks = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedBooks, 0, bookArray.length);
        Arrays.sort(sortedBooks);

        return sortedBooks;
    }

    public Book[] sortingByTitle() {
        Book[] sortedBooks = new Book[bookArray.length];
        System.arraycopy(bookArray, 0, sortedBooks, 0, bookArray.length);
        Arrays.sort(sortedBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        return sortedBooks;
    }
}
