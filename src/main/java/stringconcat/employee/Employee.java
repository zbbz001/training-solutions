package stringconcat.employee;

public class Employee {
    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if(salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }

        if(salary % 1000 != 0) {
            throw new IllegalArgumentException("Salary must be divisible by 1000.");
        }

        if(job == null || job.isEmpty()) {
            throw new IllegalArgumentException("Job must not be empty.");
        }

        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }

        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
