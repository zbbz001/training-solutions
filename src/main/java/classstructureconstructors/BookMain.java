package classstructureconstructors;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Cody Coder", "Best Top Secrets");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi a következő könyvnek a nyilvántartási száma?");
        System.out.println(book.getAuthor() + ": " + book.getTitle());
        System.out.println("nyilvántartási száma: ");
        book.register(scanner.nextLine());
        System.out.println();
        System.out.println("Minden amit tudunk a könyvről:" + book.getAuthor() + ": " + book.getTitle() + " (nysz.:" + book.getRegNumber() + ")");
    }
}
