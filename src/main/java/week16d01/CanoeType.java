package week16d01;

public enum CanoeType {
    RED(1), GREEN(1.2), BLUE(1.5);

    private double rate;

    CanoeType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
