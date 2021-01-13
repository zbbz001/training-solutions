package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {
    private static final int NUMBER_OF_FIELDS = 3;
    private static final int POSITON_OF_IP = 0;
    private static final int POSITON_OF_DATE = 1;
    private static final int POSITON_OF_LOGIN = 2;
    private static final String STRING_SEPARATOR = ":";
    private static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Map<String, List<Entry>> parseLog(String log) {
        Map<String, List<Entry>> ipEntries = new HashMap<>();

        try (Scanner scanner = new Scanner(log)) {

            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(STRING_SEPARATOR);

                if (parts.length != NUMBER_OF_FIELDS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }

                LocalDate date = dateParser(parts[POSITON_OF_DATE]);
                addToMap(ipEntries, new Entry(parts[POSITON_OF_IP], date, parts[POSITON_OF_LOGIN]));
            }
        }

        return ipEntries;
    }

    private void addToMap(Map<String, List<Entry>> map, Entry entry) {
        if (!map.containsKey(entry.getIpAddress())) {
            map.put(entry.getIpAddress(), new ArrayList<>());
        }

        map.get(entry.getIpAddress()).add(entry);
    }

    private LocalDate dateParser(String str) {
        try {
            return LocalDate.parse(str, DATE_FORMATER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }
}
