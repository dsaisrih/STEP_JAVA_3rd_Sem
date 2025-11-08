public class ATMDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC123", 10000, 1234);
        ATM atm = new ATM(account);
        Customer customer = new Customer1("Ravi", atm);

        customer.performWithdrawal(1234, 2000); // Correct PIN
        customer.performWithdrawal(1111, 1000); // Incorrect PIN
    }
}