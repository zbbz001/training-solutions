package schoolrecords;

import algorithmsmax.MaxAgeCalculator;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(List<Mark> marks, String name) {
        if(isEmpty(name)) {
            throw new NullPointerException("Student name must not be empty!");
        }

        this.marks = marks;
        this.name = name;
    }

    public Student(String name) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if(mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }

        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
        }

        return marks.size() > 0 ? (double) Math.round(sum / marks.size() * 100) / 100 : 0;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0;
        int i = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += mark.getMarkType().getValue();
                i++;
            }
        }

        return i > 0 ? (double) Math.round(sum / i * 100) / 100 : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" marks: ");

        List<StringBuilder> markTextList = new ArrayList<>();

        for (Mark mark : marks) {
            StringBuilder markText = new StringBuilder();
            markText.append(mark.getSubject().getSubjectName());
            markText.append(": ");
            markText.append(mark.toString());
            markTextList.add(markText);
        }

        sb.append(String.join(", ", markTextList));

        return sb.toString();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
