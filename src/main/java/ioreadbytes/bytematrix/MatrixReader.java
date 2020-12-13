package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    private List<byte[]> myMatrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String path) {
        Path file = Path.of(path);

        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] bytes = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                myMatrix.add(bytes);
                bytes = new byte[1000];
            }

        } catch (IOException e) {
            throw new IllegalStateException("File cannot read");
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int i = 0;
        int zeros;
        for (byte[] byteArr : myMatrix) {
            zeros = byteArr.length;
            for (byte b : byteArr) {
                if (b == 49) {
                    zeros--;
                }
            }

            if (zeros > byteArr.length / 2) {
                i++;
            }
        }

        return i;
    }

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

}
