package iofilestest.cheeseManager;

public class Cheese {
    private String name;
    private double lactose;

    public Cheese(String name, double lactose) {
        this.name = name;
        this.lactose = lactose;
    }

    @Override
    public String toString() {
        return name + ';' + lactose;
    }

    public String getName() {
        return name;
    }

    public double getLactose() {
        return lactose;
    }
}
