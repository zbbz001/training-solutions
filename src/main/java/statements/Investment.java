package statements;

public class Investment {
    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public double getYield(int days) {
        return fund * ((double)interestRate / 100) / 365 * days;
    }

    public int getFund() {
        return fund;
    }

    public double close(int days) {
        double grandTotal = (fund + getYield(days)) * (1 - cost / 100);

        double payout = active ? grandTotal : 0;

        active = false;
        return payout;
    }
}
