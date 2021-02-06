package week13d05;

import java.util.List;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, Formater formater) {
        return formater.format(billItems);
    }

    public static void main(String[] args) {
        BillWriter billWriter = new BillWriter();
        List<BillItem> billItems = List.of(
                new BillItem("kenyér", 3, 10),
                new BillItem("tej", 5, 20)
        );
        String result = billWriter.writeBills(billItems, new DetailedLineFormater());
        System.out.println(result);

    }

}
