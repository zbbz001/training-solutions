package week13d03;

import java.util.*;
import java.util.stream.Collectors;

public class Counter {

    public Optional<String> counter(List<Book> bookList) {
        if (bookList.isEmpty()) {
            return Optional.empty();
        }

//        Map<String, Integer> authorsWithPages = bookList.stream()
//                .collect(Collectors.groupingBy(b->b.getAuthor(), Collectors.summingInt(b->b.getNumberOfPages())));

        Map<String, Integer> authorsWithPages = bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingInt(Book::getNumberOfPages)));

//        return authorsWithPages.entrySet()
//                .stream()
//                .max(Comparator.comparing(b->b.getValue()))
//                .map(Map.Entry::getKey);

        return authorsWithPages.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
