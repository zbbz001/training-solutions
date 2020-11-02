package localvariables;

public class Distance {

    private double distanceKm;
    private boolean exact;

    public Distance(double distanceKm, boolean exact) {
        this.distanceKm = distanceKm;
        this.exact = exact;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public boolean isExact() {
        return exact;
    }
}
