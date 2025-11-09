import java.util.*;

class StudentRecord {
    Node head;

    class Node {
        int rollNo;
        Node next;

        Node(int r) {
            rollNo = r;
            next = null;
        }
    }

    // Insert at end
    public void insert(int rollNo) {
        Node newNode = new Node(rollNo);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display all roll numbers
    public void display() {
        if (head == null) {
            System.out.println("No students in the record!");
            return;
        }

        System.out.print("Students: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.rollNo);
            if (temp.next != null)
                System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord list = new StudentRecord();

        while (true) {
            System.out.print("Command (ADD <roll>/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ADD")) {
                int roll = sc.nextInt();
                list.insert(roll);
            } else if (cmd.equalsIgnoreCase("SHOW")) {
                list.display();
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
