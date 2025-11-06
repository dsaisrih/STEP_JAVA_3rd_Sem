class MedicalStaff {
    String name;
    public MedicalStaff(String name) { this.name = name; }
    public void scheduleShift() { System.out.println(name + " shift scheduled."); }
    public void accessIDCard() { System.out.println(name + " ID card access granted."); }
    public void processPayroll() { System.out.println(name + " payroll processed."); }
}

class Doctor extends MedicalStaff {
    public Doctor(String name) { super(name); }
    public void diagnose() { System.out.println(name + " is diagnosing patients."); }
    public void prescribe() { System.out.println(name + " is prescribing medicine."); }
    public void performSurgery() { System.out.println(name + " is performing surgery."); }
}

class Nurse extends MedicalStaff {
    public Nurse(String name) { super(name); }
    public void administerMedicine() { System.out.println(name + " administered medicine."); }
    public void monitorPatients() { System.out.println(name + " is monitoring patients."); }
}

class Technician extends MedicalStaff {
    public Technician(String name) { super(name); }
    public void operateEquipment() { System.out.println(name + " is operating equipment."); }
}

class Administrator extends MedicalStaff {
    public Administrator(String name) { super(name); }
    public void scheduleAppointment() { System.out.println(name + " scheduled an appointment."); }
}

public class Problem4 {
    public static void main(String[] args) {
        MedicalStaff[] staff = {
            new Doctor("Dr. Alice"),
            new Nurse("Nurse Bob"),
            new Technician("Tech Charlie"),
            new Administrator("Admin Diana")
        };

        for (MedicalStaff m : staff) {
            m.scheduleShift();
            m.accessIDCard();
            m.processPayroll(); // all staff do these
        }
    }
}
