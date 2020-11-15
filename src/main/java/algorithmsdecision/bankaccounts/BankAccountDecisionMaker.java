package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccountList, int greaterThan) {
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getBalance() > greaterThan) {
                return true;
            }
        }
        return false;
    }
}
