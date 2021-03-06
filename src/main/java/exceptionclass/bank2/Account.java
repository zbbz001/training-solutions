package exceptionclass.bank2;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("The account number cannot be null.");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100_000;
    }

    public double subtract(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountBankOperationException(ErrorCode.INVALID_AMOUNT);
        }

        if (balance < amount) {
            throw new LowBalanceBankOperationException(ErrorCode.LOW_BALANCE);
        }

        balance -= amount;

        return balance;
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountBankOperationException(ErrorCode.INVALID_AMOUNT);
        }

        balance += amount;

        return balance;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract <= 0) {
            throw new InvalidAmountBankOperationException(ErrorCode.INVALID_AMOUNT);
        }

        this.maxSubtract = maxSubtract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}
