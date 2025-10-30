public class Student {
    // Private instance variables
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // Default constructor
    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    // Parameterized constructor
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    // Method to display student information
    public void displayStudent() {
        System.out.println("Student Info:");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating student using default constructor
        Student student1 = new Student();
        student1.setStudentId("S101");
        student1.setName("Alice");
        student1.setGrade(85.5);
        student1.setCourse("Mathematics");

        // Creating student using parameterized constructor
        Student student2 = new Student("S102", "Bob", 72.0, "Physics");

        // Demonstrating getter methods
        System.out.println("Student 1 Name: " + student1.getName());
        System.out.println("Student 2 Course: " + student2.getCourse());

        // Displaying student information
        student1.displayStudent();
        student2.displayStudent();

        // 💬 Real-world analogy:
        // Each student object represents a unique student.
        // Their data is private and accessed via getters/setters.
        // Just like in real life, each student has their own grade and identity.
    }
}