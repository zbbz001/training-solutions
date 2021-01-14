package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> value = libraryBooks.iterator();
        Book book;
        while (value.hasNext()) {
            book = value.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }

        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> value = libraryBooks.iterator();
        Book book;
        while (value.hasNext()) {
            book = value.next();
            if (book.getRegNumber() == regNumber) {
                value.remove();
                return regNumber;
            }
        }

        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> books = new HashSet<>();
        Iterator<Book> value = libraryBooks.iterator();
        Book book;
        while (value.hasNext()) {
            book = value.next();
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }

        if (books.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }

        return books;
    }

    public Set<Book> getLibraryBooks() {
        return libraryBooks;
    }

    int libraryBooksCount() {
        return libraryBooks.size();
    }
}
