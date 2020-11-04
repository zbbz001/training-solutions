package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> searchResult = new ArrayList<>();

        for (String item : titles) {
            if (item.startsWith(prefix)) {
                searchResult.add(item);
            }
        }

        return searchResult;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void removeByPrefix(String prefix) {
        List<String> searchResult = new ArrayList<>();

        for (String item : titles) {
            if (item.startsWith(prefix)) {
                searchResult.add(item);
            }
        }

        titles.removeAll(searchResult);
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Tarzan and the Ant Men (1924)");
        books.add("Tarzan of the Apes (1912)");
        books.add("The Return of Tarzan (1913)");
        books.add("The Beasts of Tarzan (1914)");
        books.add("The Son of Tarzan (1915-1916)");
        books.add("Tarzan and the Jewels of Opar (1916)");
        books.add("Jungle Tales of Tarzan (1916-1917)");
        books.add("Tarzan the Untamed (1919-1920)");
        books.add("Tarzan the Terrible (1921)");

        System.out.println(books.findAllByPrefix("Tarzan").toString());
        System.out.println();
        System.out.println(books.getTitles().toString());
        System.out.println();
        System.out.println();
        System.out.println("___Bónusz 2");

        books.removeByPrefix("Tarzan");

        System.out.println(books.getTitles().toString());
    }
}
