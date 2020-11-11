package numbers;

public class Circle {
    private int diameter;
    private double pi;

    public Circle(int diameter) {
        this.diameter = diameter;
        pi = 3.14;
    }

    public double perimeter() {
        return pi * diameter;
    }

    public double area() {
        return pi * Math.pow(((double)diameter / 2), 2);
    }

    @Override
    public String toString() {
        return "kerület: " + perimeter() + ", terület: " + area();
    }
}
