package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> shoppingChart = new ArrayList<>();

    public void addItem(String name, int quantity) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("Item name's cannot be null or empty.");
        }

        addItemToChart(new Item(name, quantity));
    }

    public int getItem(String name) {
        Item item = getItemByName(name);
        return item == null ? 0 : item.getQuantity();
    }

    private void addItemToChart(Item item) {
        Item chartItem = getItemByName(item.getName());

        if(chartItem != null) {
            chartItem.addQuantity(item.getQuantity());
        } else {
            shoppingChart.add(item);
        }
    }

    private Item getItemByName(String name) {
        for(Item chartItem:shoppingChart) {
            if(chartItem.getName().equals(name)) {
                return chartItem;
            }
        }
        return null;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public List<Item> getShoppingChart() {
        return shoppingChart;
    }
}
