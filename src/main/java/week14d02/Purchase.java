package week14d02;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private String buyer;
    private String purchaseId;
    private List<Item> itemList = new ArrayList<>();

    public Purchase(String buyer, String purchaseId) {
        this.buyer = buyer;
        this.purchaseId = purchaseId;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public int valueOfPurcahse() {
        return itemList.stream().reduce(0, (item, item2) -> (item + item2.getPrice()), Integer::sum);
    }

    public long getNumOfItem(String itemName) {
        return itemList.stream().filter(item -> item.getName().equals(itemName)).count();
    }

    public String getBuyer() {
        return buyer;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public List<Item> getItemList() {
        return new ArrayList<>(itemList);
    }

    public static Purchase purchaseFromLine(String line) {
        String[] parts = line.split("-");

        return new Purchase(parts[0], parts[1]);
    }


    public static Purchase purchaseWithDetails(String line) {
        String[] parts = line.split(":");

        Purchase purchase = Purchase.purchaseFromLine(parts[0]);

        String[] items = parts[1].trim().split(",");

        for (String str : items) {
            purchase.addItem(Item.itemFromString(str));
        }

        return purchase;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyer='" + buyer + '\'' +
                ", purchaseId='" + purchaseId + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
