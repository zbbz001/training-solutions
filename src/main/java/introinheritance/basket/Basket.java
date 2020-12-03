package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        Item removableItem = null;

        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                removableItem = item;
            }
        }

        items.remove(removableItem);
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return items;
    }
}
