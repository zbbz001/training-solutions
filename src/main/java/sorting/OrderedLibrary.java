package sorting;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {
    Set<Book> library = new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library.isEmpty()) {
            throw new NullPointerException("Library is empty!");
        }

        Iterator<Book> value = library.iterator();

        return value.next();
    }
}
