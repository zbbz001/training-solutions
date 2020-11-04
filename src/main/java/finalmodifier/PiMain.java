package finalmodifier;

public class PiMain {

    public static void main(String[] args) {

        System.out.println(new CircleCalculator().calculatePerimeter(10));
        System.out.println(new CircleCalculator().calculateArea(10));
        System.out.println(CircleCalculator.PI);
    }
}
