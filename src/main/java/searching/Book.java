package searching;

import org.jetbrains.annotations.NotNull;

public class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String author;

    public Book(String author, String title) {
        this.title = title;
        this.author = author;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public int compareTo(@NotNull Book o) {
        if (author.compareTo(o.author) != 0) {
            return author.compareTo(o.author);
        } else {
            return title.compareTo(o.title);
        }
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

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
