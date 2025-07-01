import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountSimulation {
    static class Account {
        private String accountNumber;
        private double balance;
        private List<String> transactionHistory;

        public Account(String accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("Deposited: $" + amount);
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: $" + amount);
                System.out.println("Withdrew: $" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public void printTransactionHistory() {
            System.out.println("\nTransaction History for Account " + accountNumber + ":");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
            System.out.println("Current Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        Account account = new Account(accountNumber);
        
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}