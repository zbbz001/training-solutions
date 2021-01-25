package iofilestest.cheeseManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeseList) {
        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null!");
        }

        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (Cheese cheese : cheeseList) {
                outputStream.write(cheese.toString().getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write the file!");
        }
    }

    public Cheese findCheese(Path path, String name) {
        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null!");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The cheese's name cannot be null!");
        }

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts[0].equals(name)) {
                    return new Cheese(parts[0], Double.parseDouble(parts[1]));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read the file!");
        }

        return null;
    }
}
