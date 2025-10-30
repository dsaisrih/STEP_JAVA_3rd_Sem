
class PersonalAccount {
    // Instance variables
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Instance method: Add income
    public void addIncome(double amount, String description) {
        currentBalance += amount;
        totalIncome += amount;
        System.out.println("Income added: ₹" + amount + " | " + description);
    }

    // Instance method: Add expense
    public void addExpense(double amount, String description) {
        if (amount > currentBalance) {
            System.out.println("Insufficient balance for expense: ₹" + amount);
            return;
        }
        currentBalance -= amount;
        totalExpenses += amount;
        System.out.println("Expense recorded: ₹" + amount + " | " + description);
    }

    // Instance method: Calculate savings
    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    // Instance method: Display account summary
    public void displayAccountSummary() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Current Balance: ₹" + currentBalance);
        System.out.println("Total Income: ₹" + totalIncome);
        System.out.println("Total Expenses: ₹" + totalExpenses);
        System.out.println("Savings: ₹" + calculateSavings());
        System.out.println("-----------------------------");
    }

    // Static method: Set bank name
    public static void setBankName(String name) {
        bankName = name;
    }

    // Static method: Get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Static method: Generate account number
    public static String generateAccountNumber() {
        return "ACC" + (1000 + totalAccounts);
    }
}
public class Main {
    public static void main(String[] args) {
        // Set shared bank name
        PersonalAccount.setBankName("FinWise Bank");

        // Create multiple accounts
        PersonalAccount acc1 = new PersonalAccount("Alice");
        PersonalAccount acc2 = new PersonalAccount("Bob");
        PersonalAccount acc3 = new PersonalAccount("Charlie");

        // Perform transactions
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1200, "Groceries");
        acc1.addExpense(800, "Utilities");

        acc2.addIncome(7000, "Freelance");
        acc2.addExpense(3000, "Laptop Purchase");

        acc3.addIncome(4000, "Part-time Job");
        acc3.addExpense(1000, "Books");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Show static data
        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
    }
}