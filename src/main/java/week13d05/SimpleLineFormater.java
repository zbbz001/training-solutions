package week13d05;

import java.util.List;

public class SimpleLineFormater implements Formater {

    @Override
    public String format(List<BillItem> billItems) {
        StringBuilder sb = new StringBuilder();

        for (BillItem item : billItems) {
            String line = String.format("%d %s, darabja %d Ft", item.getNumber(), item.getName(), item.getUnitPrice());
            sb.append(line)
                    .append("\n");
        }

        return sb.toString();
    }
}
