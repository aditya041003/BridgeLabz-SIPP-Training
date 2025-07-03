class BankAccount{
    String accountNumber; double balance;
    BankAccount(String acc,double bal){ accountNumber=acc; balance=bal;}
    void displayAccountType(){ System.out.println("Generic Account"); }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(String acc,double bal,double rate){ super(acc,bal); interestRate=rate;}
    void displayAccountType(){ System.out.println("Savings Account Rate:"+interestRate+"%"); }
}
class CheckingAccount extends BankAccount{
    double withdrawalLimit;
    CheckingAccount(String acc,double bal,double limit){ super(acc,bal); withdrawalLimit=limit;}
    void displayAccountType(){ System.out.println("Checking Account Limit:"+withdrawalLimit); }
}
class FixedDepositAccount extends BankAccount{
    int term;
    FixedDepositAccount(String acc,double bal,int term){ super(acc,bal); this.term=term;}
    void displayAccountType(){ System.out.println("Fixed Deposit Term:"+term+" months"); }
}
public class BankAccountTypes{
    public static void main(String[] args){
        BankAccount[] list={ new SavingsAccount("SA001",10000,4), new CheckingAccount("CA001",5000,1000), new FixedDepositAccount("FD001",20000,12)};
        for(BankAccount acc:list) acc.displayAccountType();
    }
}