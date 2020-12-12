package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path file, int grade) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, grade + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, grade + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }

    public void average(Path file) {
        try {
            List<String> grades = Files.readAllLines(file);
            double sum = 0;
            for (String grade : grades) {
                sum += Double.parseDouble(grade);
            }

            Files.writeString(file, "average: " + (sum / grades.size()) + "\n", StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }

}
