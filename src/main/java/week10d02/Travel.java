package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {
    private int[] stops = new int[30];

    public int getStopWithMax(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineParser(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read a file", e);
        }

        return getMax();
    }

    private int getMax() {
        int max = stops[0];
        int index = 0;

        for (int i = 0; i < stops.length; i++) {
            if (stops[i] > max) {
                max = stops[i];
                index = i;
            }
        }

        return index;
    }

    private void lineParser(String line) {
        String[] parts = line.split(" ");

        stops[Integer.parseInt(parts[0])]++;
    }
}
