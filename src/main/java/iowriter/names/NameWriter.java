package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {
    Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.defaultCharset(), StandardOpenOption.APPEND)) {
            writer.write(name + "\n");
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write the file.");
        }
    }
}
