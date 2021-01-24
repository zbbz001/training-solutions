package lambdaintro;

import javax.swing.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {
    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.naturalOrder());

        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.comparing(account -> Math.abs(account.getBalance())));

        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.comparing(BankAccount::getBalance).reversed());

        return sorted;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sorted.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator)).
                thenComparing(BankAccount::getAccountNumber));

        return sorted;
    }

}
