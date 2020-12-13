package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {
    public void makeImageFile(byte[][] source, Path folder) {
        Path file = folder.resolve("image.png");

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] bytes : source) {
                bufferedOutputStream.write(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("The file cannot write.", ioe);
        }
    }
}
