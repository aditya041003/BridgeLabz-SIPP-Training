public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String holder, String accNo, double balance) {
        this.accountHolder = holder;
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Neha", "SB12345", 5000);
        acc.deposit(1000);
        acc.withdraw(3000);
        acc.displayBalance();
    }
}