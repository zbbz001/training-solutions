package exam03;

public enum CruiseClass {
    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    private double rate;

    CruiseClass(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
