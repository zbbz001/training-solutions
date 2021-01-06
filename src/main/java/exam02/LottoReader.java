package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addToNumbers(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot opened!", ioe);
        }
    }

    private void addToNumbers(String line) {
        String[] parts = line.split(";");

        for (int i = 0; i < parts.length; i++) {
            if (i >= 11) {
                numbers[Integer.parseInt(parts[i]) - 1]++;
            }
        }
    }

    public int getNumber(int index) {
        return numbers[index - 1];
    }
}