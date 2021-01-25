package lambdacomparator;

import org.jetbrains.annotations.NotNull;

public class CloudStorage implements Comparable<CloudStorage> {
    private String provider;
    private int space;
    private PayPeriod payPeriod;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this.provider = provider;
        this.space = space;
        this.payPeriod = payPeriod;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    @Override
    public int compareTo(@NotNull CloudStorage o) {
        double currentValue = this.payPeriod != null ? this.price * 12 / this.payPeriod.getLength() / this.space * 1000 : 0;
        double otherValue = o.payPeriod != null ? o.price * 12 / o.payPeriod.getLength() / o.space * 1000 : 0;
        return Double.compare(currentValue, otherValue);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    public double getPrice() {
        return price;
    }
}
