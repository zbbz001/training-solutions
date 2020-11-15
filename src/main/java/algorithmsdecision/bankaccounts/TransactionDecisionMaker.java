package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactionList, LocalDateTime startTime, LocalDateTime endTime, int greaterThen) {
        for(Transaction transaction:transactionList) {
            if(transaction.isAfter(startTime) && transaction.isBefore(endTime) && transaction.getAmount() > greaterThen) {
                return true;
            }
        }

        return false;
    }
}
