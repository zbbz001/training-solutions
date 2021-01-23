package searching;

import java.util.Arrays;

public class BookArraySearch {
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }

        Book element = new Book(author, title);
        Arrays.sort(bookArray);
        int result = Arrays.binarySearch(bookArray, element);

        if (result < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }

        return bookArray[result];
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
