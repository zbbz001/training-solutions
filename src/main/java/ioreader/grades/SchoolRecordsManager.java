package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String stringFileName) {
        Path file = Path.of("src/main/resources/" + stringFileName);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }

                students.add(new Student(parts[0], grades));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.average();
        }
        return sum / students.size();
    }

    public List<Student> getStudents() {
        return students;
    }
}
