package week13d05;

import java.util.List;

public class SimpleLineFormaterWithAmount implements Formater {

    @Override
    public String format(List<BillItem> billItems) {
        StringBuilder sb = new StringBuilder();

        for (BillItem item : billItems) {
            String line = String.format("%s %d * %d = %d", item.getName(), item.getNumber(), item.getUnitPrice(), item.getNumber() * item.getUnitPrice());
            sb.append(line)
                    .append("\n");
        }

        return sb.toString();
    }
}