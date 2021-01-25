package lambdastreams.bookstore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {
    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return books.stream().reduce(0, (e1, e2) -> e1 + e2.getQuantity(), (n1, n2) -> n1 + n2);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max((e1, e2) -> e1.getYearOfPublish() - e2.getYearOfPublish());
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (e1, e2) -> e1 + e2.getPrice() * e2.getQuantity(), (n1, n2) -> n1 + n2);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }
}
