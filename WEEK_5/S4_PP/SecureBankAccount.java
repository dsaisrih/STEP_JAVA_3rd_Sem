public class SecureBankAccount {
    private final String accountNumber; // read-only
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(initialBalance, MIN_BALANCE);
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return isLocked ? -1 : balance; }
    public boolean isAccountLocked() { return isLocked; }

    // Security
    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            resetFailedAttempts();
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid old PIN.");
        }
    }

    public boolean validatePin(int enteredPin) {
        if (enteredPin == this.pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (this.pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked!");
        } else {
            System.out.println("Incorrect PIN. Cannot unlock.");
        }
    }

    // Transactions
    public void deposit(double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit failed.");
        }
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0 && amount <= balance) {
            balance -= amount;
            target.balance += amount;
            System.out.println("Transferred: " + amount + " to " + target.getAccountNumber());
        } else {
            System.out.println("Transfer failed.");
        }
    }

    // Helpers
    private void lockAccount() { isLocked = true; }
    private void resetFailedAttempts() { failedAttempts = 0; }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
            System.out.println("Account locked due to too many failed attempts.");
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC123", 500);
        SecureBankAccount acc2 = new SecureBankAccount("ACC456", 300);

        // Setting PINs
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        // Transactions
        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);
        acc1.transfer(acc2, 150, 1234);

        // Security test
        acc1.validatePin(1111); // wrong
        acc1.validatePin(2222); // wrong
        acc1.validatePin(3333); // wrong -> account locks
        acc1.withdraw(50, 1234); // should fail
    }
}
