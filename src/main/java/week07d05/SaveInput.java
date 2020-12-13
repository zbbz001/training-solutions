package week07d05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {
    public static final int DEFAULT_LINE_NUMBER = 3;
    private Scanner scanner;


    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines(int lineNumber) {
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < lineNumber; i++) {
            System.out.print("Adja meg a(z) " + (i + 1) + ". sort: ");
            lines.add(scanner.nextLine());
        }
        return lines;
    }

    public List<String> readLines() {
        return readLines(DEFAULT_LINE_NUMBER);
    }

    public Path readFilename() {
        System.out.print("Adja meg a fájl nevét:");
        return Path.of(scanner.nextLine());
    }

    public void writeToFile(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot write", ioe);
        }
    }

    public static void main(String[] args) {
        SaveInput saveInput = new SaveInput(new Scanner(System.in));

        List<String> lines = saveInput.readLines();
        Path path = saveInput.readFilename();
        saveInput.writeToFile(path, lines);
    }
}
