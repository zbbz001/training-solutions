package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long sumTransaction = amount + costOfTransaction(amount);

        if (getBalance() + overdraftLimit < sumTransaction) {
            return false;
        }

        if (getBalance() > sumTransaction) {
            super.transaction(amount);
        } else {
            sumTransaction -= getBalance();
            super.balanceToZero();
            overdraftLimit -= sumTransaction;
        }

        return true;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
