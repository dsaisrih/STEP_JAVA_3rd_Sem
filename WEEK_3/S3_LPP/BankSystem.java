class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        totalAccounts++;
        this.accountNumber = generateAccountNumber();
    }

    private static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts);
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount.");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Invalid or insufficient funds.");
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount("Alice", 5000);
        accounts[1] = new BankAccount("Bob", 3000);
        accounts[2] = new BankAccount("Charlie", 7000);

        accounts[0].deposit(1000);
        accounts[1].withdraw(500);
        accounts[2].withdraw(8000); // Should fail

        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
            System.out.println();
        }

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }
}