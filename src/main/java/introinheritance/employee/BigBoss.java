package introinheritance.employee;

public class BigBoss extends Boss {
    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public int getNumberOfEmployees() {
        return super.getNumberOfEmployees();
    }

    public double getBonus() {
        return bonus;
    }
}
