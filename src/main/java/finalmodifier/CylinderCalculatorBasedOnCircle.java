package finalmodifier;

public class CylinderCalculatorBasedOnCircle {
    public static final double PI = 3.14;

    public double cylinderVolume(double r, double m) {
        return new CircleCalculator().calculateArea(r) * m;
    }

    public double cylinderSurfaceArea(double r, double m) {
        return new CircleCalculator().calculateArea(r) + new CircleCalculator().calculatePerimeter(r) * m;
    }

    public static void main(String[] args) {
        System.out.println("Henger felszíne: " + new CylinderCalculatorBasedOnCircle().cylinderSurfaceArea(3, 2.5));
        System.out.println("Henger térfogata: " + new CylinderCalculatorBasedOnCircle().cylinderVolume(3, 24.5));

        System.out.println(new CircleCalculator().calculatePerimeter(10));
    }

}
