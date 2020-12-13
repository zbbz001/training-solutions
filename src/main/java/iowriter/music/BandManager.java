package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                bands.add(new Band(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read the file.");
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter write = Files.newBufferedWriter(outputFile, Charset.defaultCharset())) {
            for (Band band : getOlderBands(year)) {
                write.write(band.getName() + ";" + band.getYear() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write the file.");
        }
    }

    private List<Band> getOlderBands(int year) {
        List<Band> olderBands = new ArrayList<>();

        for (Band band : bands) {
            if (band.getYear() < year) {
                olderBands.add(band);
            }
        }
        return olderBands;
    }
}
