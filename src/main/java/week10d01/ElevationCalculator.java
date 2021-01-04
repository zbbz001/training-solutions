package week10d01;

public class ElevationCalculator {
    private double down;
    private double up;

    public void calc(HikingCoordinate actual, HikingCoordinate previous) {
        if (actual.getElevation() > previous.getElevation()) {
            up += actual.getElevation() - previous.getElevation();
        } else {
            down += previous.getElevation() - actual.getElevation();
        }
    }

    public double getDown() {
        return down;
    }


    public double getUp() {
        return up;
    }
}
