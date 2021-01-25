package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class SettlementManager {

    public static void main(String[] args) {
        SettlementManager settlementManager = new SettlementManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(SettlementManager.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")));

        Settlement settlement = settlementManager.findFirstSettlementByName(reader);
        System.out.println(settlement.toString());
    }

    public Settlement findFirstSettlementByName(BufferedReader reader) {
        List<Settlement> settlements = read(reader, 1);

        if (settlements.size() == 0) {
            throw new IllegalArgumentException("No settlement in list");
        }

        settlements.sort(new Comparator<Settlement>() {
            @Override
            public int compare(Settlement o1, Settlement o2) {
                Collator collator = Collator.getInstance(new Locale("hu", "HU"));
                return collator.compare(o1.getName(), o2.getName());
            }
        });

        return settlements.get(0);
    }

    private List<Settlement> read(BufferedReader reader, int skippedRow) {
        List<Settlement> settlements = new ArrayList<>();

        try (reader) {
            String line;
            skipRows(reader, skippedRow);
            while ((line = reader.readLine()) != null) {
                settlements.add(Settlement.SettlementFromLine(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be read,", e);
        }

        return settlements;
    }

    private void skipRows(BufferedReader reader, int skippedRow) throws IOException {
        for (int i = 0; i < skippedRow; i++) {
            reader.readLine();
        }
    }


}
