package localvariables;

public class DistanceMain {

    public static void main(String[] args) {
        Distance distance = new Distance(1555.55, true);

        System.out.println("A távolság: " + distance.getDistanceKm() + ", a mérés pontos-e:" + distance.isExact());

        int integerPart = (int) distance.getDistanceKm();

        System.out.println("A távolság egész számként: " + integerPart);
    }

}
