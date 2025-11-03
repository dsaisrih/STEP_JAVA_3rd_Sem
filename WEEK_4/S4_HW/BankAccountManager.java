import java.util.Random;

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 1000);

        a2.deposit(500);
        a3.withdraw(200);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount() {
        balance = 0;
    }

    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(100000);
    }

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(100000);
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    void displayAccount() {
        System.out.println("Holder: " + accountHolder + ", Acc#: " + accountNumber +
                           ", Balance: ₹" + balance);
    }
}