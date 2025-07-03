// Sample Program 1 – Bank Account System
class BankAccount {
    private static String bankName = "National Bank";
    private static int totalAccounts = 0;

    private final long accountNumber;
    private String accountHolderName;
    private double balance;

    BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber; // 'this' resolves ambiguity
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName + " | Acc#: " + accountNumber +
                               " | Holder: " + accountHolderName + " | Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(1001L, "Alice", 5000);
        BankAccount a2 = new BankAccount(1002L, "Bob", 3000);
        a1.displayDetails();
        a2.displayDetails();
        BankAccount.getTotalAccounts();
    }
}