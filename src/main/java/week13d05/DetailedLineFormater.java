package week13d05;

import java.util.List;

public class DetailedLineFormater implements Formater {

    @Override
    public String format(List<BillItem> billItems) {
        StringBuilder sb = new StringBuilder();

        String header = String.format("%-20s %s %s %s", "Megnevezés", "Egydégár (Ft)", "Darab", "Összeg");
        sb.append(header)
                .append("\n");

        for (BillItem item : billItems) {
            String line = String.format("%-20s %13d %5d %6d", item.getName(), item.getNumber(), item.getUnitPrice(), item.getNumber() * item.getUnitPrice());
            sb.append(line)
                    .append("\n");
        }

        return sb.toString();
    }
}
