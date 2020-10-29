package classsctructureintegrate;

public class BankAccount {
    private String accountNumber, owner;
    private int balance;


    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void transfer(BankAccount to, int amount) {
        this.withdraw(amount);
        to.deposit(amount);
    }

    public String getInfo() {
        return this.owner + " (" + this.accountNumber + "): " + this.balance + " Ft";
    }
}
