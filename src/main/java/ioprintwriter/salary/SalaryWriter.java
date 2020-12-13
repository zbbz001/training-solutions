package ioprintwriter.salary;

import interfacedefaultmethods.print.Printable;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    private List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file, Charset.defaultCharset()))) {
            for (String name : names) {
                writer.print(name);
                writer.print(": ");
                writer.println(salary(name));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot write.");
        }
    }

    private int salary(String name) {
        if (name.startsWith("Dr.")) {
            return 500_000;
        } else if (name.startsWith("Mr.") || name.startsWith("Mrs.")) {
            return 200_000;
        }

        return 100_000;
    }

    private List<String> addSalaryToName() {
        List<String> saleries = new ArrayList<>();


        return saleries;
    }
}
