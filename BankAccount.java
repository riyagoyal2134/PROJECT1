package PROJECT1;
import java.util.Scanner;
public class BankAccount {
    private double balance;
    private static Scanner input;
    public BankAccount(){
        balance = 0;
    }
    public BankAccount(double initalBalance) {
        balance = initalBalance;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public double getBalance(){
        return balance;
    }
    public void monthlyFee(){
        withdraw(10);
    }
    public void overdraft(double balance, double amount){
    double feeBalance;
    double feeBalance2;
    
        if(balance>0){
            double withdrawAmount = balance - amount;
            withdraw(amount);
            if(withdrawAmount<=0){
                System.out.println("Warning: The balance after withdrawing will be $0 or below...a $35 fee will be charged after the withdrawal");
                int select; 
                System.out.println("Select 1 to proceed with withdrawal or 2 to cancel...");
                System.out.println("1: Proceed");
                System.out.println("2: Cancel");
                select = input.nextInt();

                if(select == 1){
                    feeBalance = withdrawAmount - 35;
                    System.out.println("Balance after withdrawal: " + feeBalance);
                }else if(select == 2){
                    System.out.println("Withdrawal cancelled. Balance: " + balance);
                }else{
                    System.out.println("Invalid entry");
                }
            }
        else if(withdrawAmount>=0){
                System.out.println("Balance after withdrawal: " + withdrawAmount);
            }
        }
        else if(balance<=0){
            feeBalance2 = balance - 35;
            System.out.println("Your balance is $0 or below, warning you will be charged a fee of $35");
            System.out.println("Balance: " + feeBalance2);
        }
        else{
            System.out.println("Invalid entry");
        }
    }
    public void transfer(double bankAccount1, double bankAccount2, double transferAmount){
        double balance1 = bankAccount1 - transferAmount;
        // balance1 is the amount in Bank Account 1 after the transfer to Bank 2
        double balance2 = bankAccount2 + transferAmount;
        // balance2 is the amount in Bank Account 2 after the transfer to Bank 1
        System.out.println("Bank Account 1 Balance: " + balance1);
        System.out.println("Bank Account 2 Balance: " + balance2);
    }
    // P (1 + R/n)^(nt) - P
    // P = principal
    // t = years
    // r = annual interest rate
    // n = # of times its compounded
    // PEMDAS
    public void calcInterest(double p, int t, double r, int n){
        double amount = p * Math.pow(1 + (r / n), n*t);
        double compinterest = amount - p;
        System.out.println("Compound Interest after "+ t + " years: "+ compinterest);
        System.out.println("Amount after "+ t + " years: "+ amount);
    }
    public void simpleInterest(double p, int t, double r){
        double simpleInt = (p * r* t*1/100);
        System.out.println("Simple Interest after "+ t + " years: "+ simpleInt);
    }
    public void investment(double balance, double r, double targetBalance){
        int year = 0; 
        while(balance<= targetBalance){
            year++;
            double interest = balance * r / 100;
            balance = balance + interest;
        }
        System.out.println("Total Balance: $"+ balance);
        System.out.println("Investment doubled After "+ year + " years.");
    }
    public void savingsAccount(double initialValue){
            if(initialValue>=1000){
            int value;
            System.out.println("Please select compound or flat rate interest:");
            System.out.println("1- Compound Interest");
            System.out.println("2- Flat Rate Interest");
            value = input.nextInt();
            if(value == 1){
                System.out.println("Enter the principle amount:");
                double principal = input.nextDouble();
                System.out.println("Enter the amount of years:");
                int years = input.nextInt();
                double rate = 0.0001;
                int nValue = 4;
                calcInterest(principal, years, rate, nValue);
            } if(value == 2){
                System.out.println("Enter the principle amount...");
                double principal2 = input.nextDouble();
                System.out.println("Enter the amount of years...");
                int years2 = input.nextInt();
                double rate2 = 0.001;
                simpleInterest(principal2, years2, rate2);
            }
        }
        else if(initialValue<1000){
            System.out.println("Cannot calculate the interest on the value less than $1000");
        }
        else{
            System.out.println("Invalid");
        }
    }
    public static int menu() {
        input = new Scanner(System.in);
        int selection;
        System.out.println("Please select an option:");
        System.out.println("------------------------\n");
        System.out.println("1: Get Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Transfer");
        System.out.println("5: Setting up a Savings Account");
        System.out.println("0: Quit");
        System.out.println("------------------------\n");
        selection = input.nextInt();
        return selection;
    }

}



