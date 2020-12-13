package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String path) {
        int sum = 0;
        Path file = Path.of(path);

        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = inputStream.readAllBytes();

            for (byte b : bytes) {
                if (b == 97) {
                    sum++;
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        return sum;
    }

}
