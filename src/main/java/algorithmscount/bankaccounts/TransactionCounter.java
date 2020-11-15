package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactionList, int lessThan) {
        int countTransaction = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.getAmount() < lessThan) {
                countTransaction++;
            }
        }
        return countTransaction;
    }
}
