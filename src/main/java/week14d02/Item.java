package week14d02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Item itemFromString(String str) {

        Pattern pattern = Pattern.compile("([A-Za-z]+)\\(([0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if (matchFound) {
            String name = matcher.group(1);
            int price = Integer.parseInt(matcher.group(2));

            return new Item(name, price);
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
