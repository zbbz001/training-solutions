package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("Túlélőkészlet", 10, 10.5));
        bill.addItem(new Item("Vizipipa", 8, 32.5));
        bill.addItem(new Item("Szivárvány", 45, 162.1));

        System.out.println("a számla végösszege: " + bill.calculateTotalPrice());
    }
}
