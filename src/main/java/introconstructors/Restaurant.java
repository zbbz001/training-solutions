package introconstructors;

import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        this.menu = addMenu();
    }

    private List<String> addMenu() {
        return Arrays.asList("Texas Bacon King", "Chili Cheese Bacon King", "Bacon King");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


}
