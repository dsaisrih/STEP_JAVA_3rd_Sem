public class LibraryDemo {
    public static void main(String[] args) {
        Library lib = new Library("Central City");

        Book b1 = new Book("1984", "George Orwell", "ISBN001");
        Book b2 = new Book("Brave New World", "Aldous Huxley", "ISBN002");
        Book b3 = new Book("Fahrenheit 451", "Ray Bradbury", "ISBN003");

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        lib.showBooks();

        Member m = new Member("Ravi");
        m.borrowBook(b1);
        m.borrowBook(b3);

        m.showBorrowedBooks();
    }
}