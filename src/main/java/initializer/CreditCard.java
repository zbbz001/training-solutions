package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private long balance;
    private Currency currency;
    private static final List<Rate> RATE_LIST = new ArrayList<>();

    public CreditCard(long balance, Currency currency, List<Rate> rateList) {
        RATE_LIST.addAll(rateList);
        this.balance = convert(balance, currency);
        this.currency = currency;
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public boolean payment(long amount, Currency currency) {
        amount = convert(amount, currency);
        if (!enoughBalance(amount)) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    private boolean enoughBalance(long amount) {
        return balance >= amount;
    }

    private long convert(long amount, Currency currency) {
        for (Rate rate : RATE_LIST) {
            if (currency == rate.getCurrency()) {
                amount = (long) (amount * rate.getConversionFactor());
            }
        }

        return amount;
    }

    public long getBalance() {
        return balance;
    }
}
