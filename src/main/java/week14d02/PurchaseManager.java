package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PurchaseManager {
    private List<Purchase> purchaseList = new ArrayList<>();

    public void read(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            Purchase purchase = Purchase.purchaseWithDetails(line);
            purchaseList.add(purchase);
        }
    }

    public int getSumOfPurchase(String purchaseId) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getPurchaseId().equals(purchaseId))
                .reduce(0, (purchase, purchase2) -> (purchase + purchase2.valueOfPurcahse()), Integer::sum);
    }

    public int getSumOfAllPurchaseByTheBuyer(String buyer) {
        return purchaseList.stream()
                .filter(purchase -> purchase.getBuyer().equals(buyer))
                .reduce(0, (purchase, purchase2) -> (purchase + purchase2.valueOfPurcahse()), Integer::sum);
    }

    public List<Item> sortPurchase(String buyer, String purchaseId, Comparator comparator) {
        List<Item> sortedList = purchaseList.stream()
                .filter(purchase -> (purchase.getBuyer().equals(buyer) && purchase.getPurchaseId().equals(purchaseId)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                            if (list.size() != 1) {
                                throw new IllegalStateException("no purchase found");
                            }
                            return list.get(0);
                        }
                ))
                .getItemList();

        sortedList.sort(comparator);

        return sortedList;
    }

    public long getNumberOfOrder(String itemName) {
        return purchaseList.stream().reduce(0L, (i, j) -> (i + j.getNumOfItem(itemName)), Long::sum);
    }

    public Map<String, Long> itemStat() {
        List<String> itemList = new ArrayList<>();
        purchaseList.forEach(purchase -> purchase.getItemList().forEach(item -> itemList.add(item.getName())));

        return itemList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Purchase> getPurchaseList() {
        return new ArrayList<>(purchaseList);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(PurchaseManager.class.getResourceAsStream("/purchaselist.txt")))) {
            PurchaseManager purchaseManager = new PurchaseManager();
            purchaseManager.read(reader);

            //System.out.println(purchaseManager.getPurchaseList());

//            System.out.println(purchaseManager.getSumOfPurchase("1211"));
//            System.out.println(purchaseManager.getSumOfAllPurchaseByTheBuyer("BK123"));
//            System.out.println(purchaseManager.sortPurchase("BK123", "1211", Comparator.comparing(Item::getName)));
//            System.out.println(purchaseManager.sortPurchase("BK123", "1211", Comparator.comparing(Item::getPrice)));
//            System.out.println(purchaseManager.getNumberOfOrder("bread"));
            System.out.println(purchaseManager.itemStat());

        } catch (IOException e) {
            throw new IllegalStateException("File cannot read!", e);
        }

    }
}
