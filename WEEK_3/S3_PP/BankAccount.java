public class BankAccount {
    // Static variables (shared across all accounts)
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // Instance variables (unique to each account)
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++; // Increment shared counter
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println();
    }

    // Instance methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("Account Info:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Interest Earned: ₹" + calculateInterest());
        System.out.println();
    }

    public static void main(String[] args) {
        // Set static members using class name
        BankAccount.setBankName("Copilot Bank");
        BankAccount.setInterestRate(5.0);

        // Create multiple BankAccount objects
        BankAccount acc1 = new BankAccount("A101", "Alice", 10000);
        BankAccount acc2 = new BankAccount("A102", "Bob", 15000);

        // Demonstrate static members (shared)
        BankAccount.displayBankInfo(); // Called using class name
        acc1.displayBankInfo();        // Also valid, but not recommended

        // Demonstrate instance members (unique)
        acc1.deposit(2000);
        acc2.withdraw(5000);

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        // Show total accounts using static method
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}