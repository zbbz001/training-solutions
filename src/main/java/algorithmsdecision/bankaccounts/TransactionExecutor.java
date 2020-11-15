package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactionList, List<BankAccount> bankAccountList) {
        for (Transaction transaction : transactionList) {
            for (BankAccount bankAccount : bankAccountList) {
                if (bankAccount.getAccountNumber().equals(transaction.getAccountNumber())) {
                    if (transaction.isCredit()) {
                        bankAccount.deposit(transaction.getAmount());
                    } else {
                        bankAccount.withdraw(transaction.getAmount());
                    }
                }
            }
        }
    }
}
