class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "ContactInfo [email=" + email + ", phone=" + phone + "]";
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", contact=" + contact + "]";
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c1 = new ContactInfo("abc@example.com", "1234567890");
        Student s1 = new Student("S101", "Alice", c1);

        // Shallow clone
        Student s2 = (Student) s1.clone();
        // Deep clone
        Student s3 = s1.deepClone();

        // Change contact info
        s2.contact.email = "changed@example.com";

        System.out.println("Original: " + s1);
        System.out.println("Shallow Clone: " + s2);
        System.out.println("Deep Clone: " + s3);
    }
}
