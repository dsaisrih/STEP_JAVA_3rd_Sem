public class LibraryBookSystem {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Brave New World", "Aldous Huxley", "1234567890", true);

        b2.borrowBook();
        b3.returnBook();

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}

class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    Book() {
        title = "";
        author = "";
        isbn = "";
        isAvailable = true;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        isbn = "";
        isAvailable = true;
    }

    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        isAvailable = false;
    }

    void returnBook() {
        isAvailable = true;
    }

    void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author +
                           ", ISBN: " + isbn + ", Available: " + isAvailable);
    }
}