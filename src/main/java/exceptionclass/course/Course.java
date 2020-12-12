package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null) {
            throw new IllegalArgumentException("The course's name cannot be null");
        }
        if (begin == null) {
            throw new IllegalArgumentException("The course's begin cannot be null");
        }

        this.name = name;
        this.begin = begin;
    }

    @Override
    public String toString() {
        return begin + ": " + name;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }
}
