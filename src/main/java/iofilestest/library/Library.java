package iofilestest.library;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    public void add(Book... books) {
        if (books == null) {
            throw new IllegalArgumentException("The list of books cannot be null!");
        }

        for (Book book : books) {
            if (!isContains(book)) {
                this.books.add(book);
            }
        }
    }

    private boolean isContains(Book searched) {
        for (Book book : books) {
            if (searched.toString().equals(book.toString())) {
                return true;
            }
        }

        return false;
    }

    public void save(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null!");
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path)))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write the file!");
        }
    }

    public void load(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null!");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                add(new Book(parts[0], parts[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read the file!");
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<Book>(books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
