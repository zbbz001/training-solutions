package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankAccountList, int greaterThan) {
        int countAccount = 0;
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getBalance() > greaterThan) {
                countAccount++;
            }
        }
        return countAccount;
    }

}
