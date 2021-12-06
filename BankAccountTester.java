package PROJECT1;
import java.util.Scanner;
public class BankAccountTester {
        public static Scanner sc = new Scanner (System.in);
        public static void main(String[] args) {
        BankAccount gregChecking = new BankAccount();
        BankAccount bobChecking = new BankAccount(10000);
        System.out.println(gregChecking.getBalance());
        System.out.println("Balance Starting");
        System.out.println(bobChecking.getBalance());
        bobChecking.withdraw(500);
        System.out.println("Balance After withdraw");
        System.out.println(bobChecking.getBalance());
        bobChecking.deposit(100);
        System.out.println("Balance After Deposit");
        System.out.println(bobChecking.getBalance());
        // gregChecking.monthlyFee();
        System.out.println(gregChecking.getBalance());
        gregChecking.deposit(100);
        System.out.println("--------------------------------------------------------------");
        // Showing the result for simple interest (Ans 3)
        BankAccount output =new BankAccount();
        output.simpleInterest(200, 4, 2);
        System.out.println("--------------------------------------------------------------");
        // Showing the result for (Ans 1,2,4,5)
        System.out.println("Hello welcome to your Bank Account.");
        System.out.println("How much money would you like to start it:");
        double startingBal = sc.nextDouble();
        BankAccount user = new BankAccount(startingBal);
        int menuSelection = BankAccount.menu();
        if (menuSelection == 1){
            // to get the balance
            System.out.println("Getting Account Balance:");
            System.out.println("Total Balance: $"+user.getBalance());
        } else if (menuSelection == 2) {
            // for depositing the money
            System.out.println("Please enter the amount to deposit:");
            double depositAmount = sc.nextDouble();
            user.deposit(depositAmount);
            System.out.println("Amount: $" + depositAmount + " was deposited");
            System.out.println("Total Balance: $"+user.getBalance());
        }else if (menuSelection == 3){
            // to withdraw by using overdraft method
            System.out.println("Please enter the amount to withdraw:");
            double withdrawAmount = sc.nextDouble();
            output.overdraft(user.getBalance(), withdrawAmount);
            System.out.println("Amount: $" + withdrawAmount + " was withdrawn");
        }else if(menuSelection == 4){
            // for transferring the money
            System.out.println("Enter your balance for Bank Account 1:");
            double bank1 = sc.nextDouble();
            System.out.println("How much would you like to transfer to Bank Account 2:");
            double transferBank = sc.nextDouble();
            System.out.println("Enter your balance for Bank Account 2:");
            double bank2 = sc.nextDouble();
            user.transfer(bank1, bank2, transferBank);
        }else if(menuSelection == 5){
            // setting up savings account
            System.out.println("Creating a Savings Account. How much amount would you like to start it:");
            double initialSavings = sc.nextDouble();
            user.savingsAccount(initialSavings);
        }else if (menuSelection == 0){
            System.out.println("Exit");
        }else{
            System.out.println("Please select vaild number");
        }
    }
}