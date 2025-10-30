class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
        this.bookId = generateBookId();
    }

    private static String generateBookId() {
        return "B" + String.format("%03d", totalBooks);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBookId() {
        return bookId;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued = new String[5];
    private int bookCount = 0;
    private static int totalMembers = 0;

    public Member(String name) {
        this.memberName = name;
        totalMembers++;
        this.memberId = "M" + String.format("%03d", totalMembers);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < booksIssued.length) {
            book.issueBook();
            booksIssued[bookCount++] = book.getBookId();
            System.out.println(memberName + " borrowed " + book.getBookId());
        } else {
            System.out.println("Cannot borrow book.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId().equals(bookId)) {
                books[i].returnBook();
                System.out.println(memberName + " returned " + bookId);
                break;
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Java Basics", "James Gosling"),
            new Book("Python 101", "Guido van Rossum"),
            new Book("C++ Primer", "Bjarne Stroustrup")
        };

        Member[] members = {
            new Member("Alice"),
            new Member("Bob")
        };

        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[1]);
        members[0].returnBook("B001", books);

        for (Book book : books) {
            book.displayBookInfo();
        }

        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}