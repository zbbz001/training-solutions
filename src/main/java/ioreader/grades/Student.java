package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> gradeList = new ArrayList<>();

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public double average() {
        double sum = 0;

        for (int grade : gradeList) {
            sum += grade;
        }
        return sum / gradeList.size();
    }

    public boolean isIncreasing() {
        int temp = gradeList.get(0);

        for (int grade : gradeList) {
            if (grade < temp) {
                return false;
            }
            temp = grade;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }
}
