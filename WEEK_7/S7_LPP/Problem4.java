class LibraryUser {
    String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Library User: " + name);
    }

    public void enterLibrary() {
        System.out.println(name + " entered the library.");
    }
}

class Student extends LibraryUser {
    public Student(String name) {
        super(name);
    }

    public void borrowBook() {
        System.out.println(name + " borrowed a book.");
    }

    public void accessComputer() {
        System.out.println(name + " is using a computer.");
    }
}

class Faculty extends LibraryUser {
    public Faculty(String name) {
        super(name);
    }

    public void reserveBook() {
        System.out.println(name + " reserved a book.");
    }

    public void accessResearchDatabase() {
        System.out.println(name + " is accessing research databases.");
    }
}

class Guest extends LibraryUser {
    public Guest(String name) {
        super(name);
    }

    public void browseBooks() {
        System.out.println(name + " is browsing books.");
    }
}

public class Problem4 {
    public static void main(String[] args) {
        // Upcasting: all stored as LibraryUser
        LibraryUser u1 = new Student("Alice");
        LibraryUser u2 = new Faculty("Bob");
        LibraryUser u3 = new Guest("Charlie");

        LibraryUser[] users = {u1, u2, u3};

        for (LibraryUser user : users) {
            user.enterLibrary();
            user.displayInfo(); // only common features accessible
        }
    }
}
