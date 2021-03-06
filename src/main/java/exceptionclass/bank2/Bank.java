package exceptionclass.bank2;

import java.util.List;

public class Bank {
    private List<Account> accountList;

    public Bank(List<Account> accountList) {
        if (accountList == null) {
            throw new IllegalArgumentException("The account list cannot be null.");
        }

        this.accountList = accountList;
    }

    public void payment(String accountNumber, double amount) throws InvalidAccountNumberBankOperationException {
        Account account = getAccountByAccountNumber(accountNumber);

        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) throws InvalidAccountNumberBankOperationException {
        Account account = getAccountByAccountNumber(accountNumber);

        account.deposit(amount);
    }

    private Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        throw new InvalidAccountNumberBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
