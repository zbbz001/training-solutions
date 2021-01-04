package week10d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HikingFile {

    public ElevationCalculator getElevation(InputStream inputStream) {
        ElevationCalculator ec = new ElevationCalculator();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            HikingCoordinate previous = null;
            while ((line = reader.readLine()) != null) {
                HikingCoordinate actual = new HikingCoordinate(line);

                if (previous != null) {
                    ec.calc(actual, previous);
                }

                previous = actual;
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("File cannot read", e);
        }

        return ec;
    }
}
