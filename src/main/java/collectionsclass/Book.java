package collectionsclass;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    @Override
    public int compareTo(@NotNull Book o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
