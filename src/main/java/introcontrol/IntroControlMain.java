package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl introControl = new IntroControl();

        System.out.println(introControl.substractTenIfGreaterThanTen(10));
        System.out.println(introControl.substractTenIfGreaterThanTen(11));

        System.out.println(introControl.describeNumber(10));
        System.out.println(introControl.describeNumber(0));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Cody"));

        System.out.println(introControl.calculateBonus(1000001));
        System.out.println(introControl.calculateBonus(999999));

        System.out.println(introControl.calculateConsumption(511, 601));
        System.out.println(introControl.calculateConsumption(8900, 112));

        introControl.printNumbers(5);

        introControl.printNumbersBetween(2, 9);


        introControl.printNumbersBetweenAnyDirection(1,3);
        introControl.printNumbersBetweenAnyDirection(6,3);

        introControl.printOddNumbers(9);


    }
}
