package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class BalatonStorm {
    private static final String STATION_DATA_START = "\"id\":";
    private static final String STATION_DATA_END = "\"stationType\":";
    private static final int STORM_LEVEL = 3;

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<BalatonStation> stations = readAllInfo(reader);

        return stations.stream()
                .filter(balatonStation -> balatonStation.getLevel() == STORM_LEVEL)
                .map(BalatonStation::getStation)
                .sorted(Collator.getInstance(new Locale("hu", "HU")))
                .collect(Collectors.toList());
    }

    private List<BalatonStation> readAllInfo(BufferedReader reader) throws IOException {
        List<BalatonStation> stations = new ArrayList<>();
        String line;
        String[] stationLines = new String[8];
        int index = 0;
        boolean isData = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains(STATION_DATA_START)) {
                isData = true;
            }

            if (isData) {
                stationLines[index] = line;
                index++;
            }

            if (line.contains(STATION_DATA_END)) {
                isData = false;
                index = 0;
                stations.add(new BalatonStation().stationFromString(stationLines));
                stationLines = new String[8];
            }
        }

        return stations;
    }

}
