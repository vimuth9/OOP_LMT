import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        // Adding some initial data
        library.addStaff(new Staff("Rivindu", "Rivindu123"));
        library.addStaff(new Staff("Vimuth", "Vimuth123"));
        library.addBook(new Book("Harry Potter", "J.K. Rowling"));
        library.addBook(new Book("Alice in Wonderland", "Lewis Carrol"));
        library.addMember(new Member("amal kumara", "1234567890"));
        library.addMember(new Member("sunil shantha", "123498764"));

        boolean authenticated = false;
        while (!authenticated) {
            System.out.println("\n=== Login ===");

            System.out.println("Enter Username:");
            String username = scanner.nextLine();

            System.out.println("Enter Password:");
            String password = scanner.nextLine();


            authenticated = Library.authenticate(username, password);
            if (!authenticated) {
                System.out.println("incorrect username or password");
            }
        }

        boolean exit = false;


        while (!exit) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Show Available Books");
            System.out.println("4. Add Member");
            System.out.println("5. Remove Member");
            System.out.println("6. Show All Members");
            System.out.println("7. Lend Book");
            System.out.println("8. Return Book");
            System.out.println("9. Show All Transactions");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add Book
                    // removed so that the book ID is calculated automatically
//                    System.out.print("Enter Book ID: ");
//                    int bookId = scanner.nextInt();
//                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2: // Remove Book
                    System.out.print("Enter Book ID to remove: ");
                    int removeBookId = scanner.nextInt();
                    Book bookToRemove = library.findBookById(removeBookId);
                    if (bookToRemove != null) {
                        library.getAvailableBooks().remove(bookToRemove);
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3: // Show Available Books
                    System.out.println("\nAvailable Books:");
                    for (Book book : library.getAvailableBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 4: // Add Member
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Member Contact: ");
                    String contact = scanner.nextLine();
                    library.addMember(new Member(memberName, contact));
                    System.out.println("Member added successfully!");
                    break;

                case 5: // Remove Member
                    System.out.print("Enter Member ID to remove: ");
                    int removeMemberId = scanner.nextInt();
                    Member memberToRemove = null;
                    for (Member member : library.getMembers()) {
                        if (member.getMemberId() == removeMemberId) {
                            memberToRemove = member;
                            break;
                        }
                    }
                    if (memberToRemove != null) {
                        library.getMembers().remove(memberToRemove);
                        System.out.println("Member removed successfully!");
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 6: // Show All Members
                    System.out.println("\nAll Members:");
                    for (Member member : library.getMembers()) {
                        System.out.println(member);
                    }
                    break;

                case 7: // Lend Book
                    System.out.print("Enter Member ID: ");
                    int lendMemberId = scanner.nextInt();
                    System.out.print("Enter Book ID to lend: ");
                    int lendBookId = scanner.nextInt();
                    Transaction transaction = library.lendBook(lendMemberId, lendBookId);
                    if (transaction != null) {
                        System.out.println("Book lent successfully!");
                        System.out.println(transaction);
                    } else {
                        System.out.println("Failed to lend book. Book may not be available.");
                    }
                    break;

                case 8: // Return Book
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    String returnDate = scanner.next();
                    LocalDate parsedReturnDate = LocalDate.parse(returnDate);
                    for (Transaction trans : library.getTransactions()) {
                        if (trans.getBookId() == returnBookId && trans.getReturnDate() == null) {
                            trans.returnBook(parsedReturnDate);
                            Book returnedBook = library.findBookById(returnBookId);
                            if (returnedBook != null) returnedBook.setAvailable(true);
                            System.out.println("Book returned successfully! Fine: $" + trans.calculateFine());
                            break;
                        }
                    }
                    break;

                case 9: // Show All Transactions
                    System.out.println("\nAll Transactions:");
                    for (Transaction trans : library.getTransactions()) {
                        System.out.println(trans);
                    }
                    break;

                case 10: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
