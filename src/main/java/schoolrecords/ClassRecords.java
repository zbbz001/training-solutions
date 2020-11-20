package schoolrecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public ClassRecords(String className, Random rnd, List<Student> students) {
        this.className = className;
        this.rnd = rnd;
        this.students = students;
    }

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        for (Student existingStudent : students) {
            if (existingStudent.getName().equals(student.getName())) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for (Student studentFromList : students) {
            if (studentFromList.getName().equals(student.getName())) {
                students.remove(studentFromList);
                return true;
            }
        }

        return false;
    }

    public double calculateClassAverage() {
        double sum = 0;

        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        for (Student student : students) {
            sum += student.calculateAverage();
        }

        if (sum == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return (double) Math.round(sum / students.size() * 100) / 100;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        int i = 0;
        double sum = 0;
        for (Student student : students) {
            double studentAverageOfSubject = student.calculateSubjectAverage(subject);
            if (studentAverageOfSubject > 0) {
                i++;
                sum += studentAverageOfSubject;
            }
        }

        return i > 0 ? (double) Math.round(sum / i * 100) / 100 : 0;
    }

    public Student findStudentByName(String name) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }

        if(students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }

        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }

        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {
        if(students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }

        return students.get(rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();

        for (Student student : students) {
            studyResultByNames.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }

        return studyResultByNames;
    }

    public String listStudentNames() {
        List<String> studentNames = new ArrayList<>();

        for (Student student : students) {
            studentNames.add(student.getName());
        }

        return String.join(", ", studentNames);
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

}


