package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<BankAccount> accountList = new ArrayList<>();

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for (String line : lines) {
                String[] parts = line.split(";");
                accountList.add(new BankAccount(parts[0], parts[1], Double.parseDouble(parts[2])));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void makeTransactions(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for (String line : lines) {
                String[] parts = line.split(";");
                BankAccount account = getAccountByaccountNumber(parts[0]);
                account.setBalance(Double.parseDouble(parts[1]));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private BankAccount getAccountByaccountNumber(String accountNumber) {
        for (BankAccount account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        throw new IllegalStateException("Account not exists.");
    }
}