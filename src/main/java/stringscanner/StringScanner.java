package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        int sumValue = 0;
        if(delimiter == null) {
            delimiter = " ";
        }

        Scanner scanner = new Scanner(intString).useDelimiter(delimiter);

        try {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    sumValue += scanner.nextInt();
                } else {
                    throw new IllegalArgumentException("Incorrect parameter string!");
                }
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        return sumValue;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, " ");
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }

        Scanner scanner = new Scanner(text);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(word)) {
                if(sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        }

        return sb.toString();
    }
}
