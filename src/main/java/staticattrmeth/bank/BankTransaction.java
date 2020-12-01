package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {
    private long trxValue;
    private static final long MIN_TRX_VALUE = 1;
    private static final long MAX_TRX_VALUE = 10_000_000;
    private static long currentMinValue = MAX_TRX_VALUE;
    private static long currentMaxValue = MIN_TRX_VALUE;
    private static long numOfTrxs;
    private static BigDecimal sumOfTrxs = new BigDecimal(0);

    public static BigDecimal averageOfTransaction() {
        return numOfTrxs == 0 ? new BigDecimal(0) : sumOfTrxs.divide(new BigDecimal(numOfTrxs));
    }

    public static void initTheDay() {
        currentMinValue = MAX_TRX_VALUE;
        currentMaxValue = MIN_TRX_VALUE;
        numOfTrxs = 0;
        sumOfTrxs = new BigDecimal(0);
    }

    public static long getCurrentMinValue() {
        return numOfTrxs == 0 ? 0 : currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return numOfTrxs == 0 ? 0 : currentMaxValue;
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public BankTransaction(long trxValue) {
        if (trxValue < MIN_TRX_VALUE || trxValue > MAX_TRX_VALUE) {
            throw new IllegalArgumentException("The transaction's value is incorrect, trxValue: " + trxValue);
        }

        this.trxValue = trxValue;
        numOfTrxs++;
        sumOfTrxs = sumOfTrxs.add(new BigDecimal(Long.toString(trxValue)));

        if (trxValue < currentMinValue) {
            currentMinValue = trxValue;
        }

        if (trxValue > currentMaxValue) {
            currentMaxValue = trxValue;
        }
    }
}
