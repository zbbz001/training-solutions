package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String author;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
    }

    @Override
    public int compareTo(@NotNull Book o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
