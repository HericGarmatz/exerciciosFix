import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        Account a = new Account(123, "Heric", 100);
        BusinessAccount bacc = new BusinessAccount(1234, "Test", 0.0 , 500.0);

        //UpCasting
        Account a1= bacc;
        Account a2= new BusinessAccount(321, "UpCasting", 0, 100.0);
        Account a3= new SavingsAccount(4321, "a4", 0, 0.1);

        //DownCasting

        BusinessAccount a4 =(BusinessAccount)a2;
        a4.loan(100.0);

        //BusinessAccount a5 = (BusinessAccount) a3;
        if(a3 instanceof BusinessAccount){
            BusinessAccount a5 = (BusinessAccount) a3;
            a5.loan(200.0);
            System.out.println("Loan!");
        }
        if(a3 instanceof SavingsAccount){
            SavingsAccount a5 = (SavingsAccount)a3;
            a5.updateBalance();
            System.out.println("Update!");
        }
    }
}
