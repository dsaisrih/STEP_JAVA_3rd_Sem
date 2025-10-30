class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;

    public Employee(String name, String dept, double salary) {
        this(name, dept, salary, "Full-Time");
    }

    public Employee(String name, String dept, double hourlyRate, int hours) {
        this(name, dept, hourlyRate * hours, "Part-Time");
    }

    public Employee(String name, String dept, double fixedAmount, boolean isContract) {
        this(name, dept, fixedAmount, "Contract");
    }

    private Employee(String name, String dept, double salary, String type) {
        this.empName = name;
        this.department = dept;
        this.baseSalary = salary;
        this.empType = type;
        totalEmployees++;
        this.empId = "E" + String.format("%03d", totalEmployees);
    }

    public double calculateSalary() {
        if (empType.equals("Full-Time")) return baseSalary + 5000;
        else if (empType.equals("Part-Time")) return baseSalary;
        else return baseSalary;
    }

    public double calculateTax() {
        if (empType.equals("Full-Time")) return calculateSalary() * 0.2;
        else if (empType.equals("Part-Time")) return calculateSalary() * 0.1;
        else return calculateSalary() * 0.15;
    }

    public void generatePaySlip() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Type: " + empType);
        System.out.println("Salary: ₹" + calculateSalary() + ", Tax: ₹" + calculateTax());
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "HR", 50000);
        Employee e2 = new Employee("Bob", "IT", 200, 20);
        Employee e3 = new Employee("Charlie", "Finance", 30000, true);

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}