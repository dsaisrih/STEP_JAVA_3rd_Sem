// Employee.java
abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

// Interface
interface Payable {
    void generatePaySlip();
}

// Manager class
class Manager extends Employee implements Payable {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.20;  // 20% bonus
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip for Manager: " + name);
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total: " + (salary + calculateBonus()));
    }

    public static void main(String[] args) {
        Manager m = new Manager("Alice", 80000);
        m.generatePaySlip();
    }
}
