package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path file = Path.of(pathString);

        try {
            byte[] temps = Files.readAllBytes(file);
            return new Temperatures(temps);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open file", ioe);
        }
    }
}
