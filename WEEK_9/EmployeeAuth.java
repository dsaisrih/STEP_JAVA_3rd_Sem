import java.util.HashSet;
import java.util.Set;

class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    // equals() based on empCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return empCode.equals(other.empCode);
    }

    // hashCode() based on empCode
    @Override
    public int hashCode() {
        return empCode.hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return "Employee [empCode=" + empCode + ", name=" + name + "]";
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");

        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));

        Set<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2); // will not add because empCode is same
        System.out.println(employees);
    }
}
