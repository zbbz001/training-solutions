package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {
    private Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            owls.put(parts[0], Integer.valueOf(parts[1]));
        }
    }

    public int getNumberOfOwls(String countyName) {
        return owls.get(countyName);
    }

}
