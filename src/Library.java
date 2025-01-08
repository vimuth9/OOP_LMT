import java.time.LocalDate;
import java.util.ArrayList;


public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int transactionIdCounter = 1;

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Add methods for each operation (addBook, removeBook, etc.)
    public void addBook(Book book) {
        books.add(book);
        book.displayBookDetails();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) availableBooks.add(book);
        }
        return availableBooks;
    }

    public Transaction lendBook(int memberId, int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            Transaction transaction = new Transaction(transactionIdCounter++, memberId, bookId, LocalDate.now());
            transactions.add(transaction);
            return transaction;
        }
        return null;
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) return book;
        }
        return null;
    }

    public static boolean  authenticate(String username, String password) {
        for (Staff staff : staffList) {
            if (staff.getUsername().equals(username) && staff.verifyPassword(password)) {
                return true;
            }
        }
        return false;
    }

    // Add similar methods for other operations
}

