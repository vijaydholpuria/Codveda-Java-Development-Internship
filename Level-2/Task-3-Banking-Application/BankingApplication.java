import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;
        System.out.println("Amount Deposited Successfully.");
        System.out.println("Current Balance: " + balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance Please Check Your Balance.");
            return;
        }

        balance -= amount;
        System.out.println("Amount Withdrawn Successfully.");
        System.out.println("Current Balance: " + balance);
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(0);

        while (true) {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("***** DEPOSIT MONEY *****");
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("***** WITHDRAW MONEY *****");
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("***** CHECK BALANCE *****");

                    account.checkBalance();
                    break;

                case 4:
                    
                    System.out.println("Thank You for using the Banking System.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}