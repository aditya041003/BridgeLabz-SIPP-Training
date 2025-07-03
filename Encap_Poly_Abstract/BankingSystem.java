// Problem 4 – Banking System
abstract class BankAccountBS {
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccountBS(String acc, String name, double bal) {
        this.accountNumber = acc;
        this.holderName = name;
        this.balance = bal;
    }

    public double getBalance() { return balance; }
    public void deposit(double amt) { balance += amt; }
    public void withdraw(double amt) { if (balance >= amt) balance -= amt; }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccountBS extends BankAccountBS implements Loanable {
    SavingsAccountBS(String acc, String name, double bal) { super(acc, name, bal); }
    @Override public double calculateInterest() { return getBalance() * 0.04; } // 4%
    @Override public void applyForLoan(double amount) {
        System.out.println("Savings Loan applied for ₹" + amount);
    }
    @Override public boolean calculateLoanEligibility() { return getBalance() > 5000; }
}

class CurrentAccountBS extends BankAccountBS implements Loanable {
    CurrentAccountBS(String acc, String name, double bal) { super(acc, name, bal); }
    @Override public double calculateInterest() { return 0; }
    @Override public void applyForLoan(double amount) {
        System.out.println("Current Loan applied for ₹" + amount);
    }
    @Override public boolean calculateLoanEligibility() { return getBalance() > 10000; }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccountBS[] list = {
            new SavingsAccountBS("SA001", "Ravi", 8000),
            new CurrentAccountBS("CA001", "Dolma Ltd.", 20000)
        };
        for (BankAccountBS acc : list) {
            System.out.println("Interest: " + acc.calculateInterest());
            ((Loanable) acc).applyForLoan(50000);
            System.out.println("Eligible? " + ((Loanable) acc).calculateLoanEligibility());
            System.out.println("---");
        }
    }
}