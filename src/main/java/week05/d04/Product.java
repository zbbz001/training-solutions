package week05.d04;

public class Product {
    private long price;
    private CurrencyType currency;
    private static final double EXCHANGE_RATE = 300.0;

    public Product(long price, CurrencyType currency) {
        if (currency == null) {
            throw new IllegalArgumentException("The currency is cannot be null.");
        }

        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(CurrencyType currency) {
        if (!currency.equals(this.currency)) {
            if (currency.equals("HUF")) {
                return price * EXCHANGE_RATE;
            } else {
                return price / EXCHANGE_RATE;
            }
        }

        return (double) price;
    }
}
