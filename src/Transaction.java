
import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int memberId;
    private int bookId;
    private LocalDate lendDate;
    public static int transactionCount = 0;

    public int getTransactionId() {
        return transactionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDate getLendDate() {
        return lendDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    private LocalDate returnDate;

    public Transaction(int transactionId, int memberId, int bookId, LocalDate lendDate) {
        this.transactionId = ++transactionCount;
        this.memberId = memberId;
        this.bookId = bookId;
        this.lendDate = lendDate;
        this.returnDate = null; // Not returned yet
    }

    // Calculate fine (if returned late)
    public long calculateFine() {
        if (returnDate == null) return 0; // No fine if not returned
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(lendDate, returnDate) - 14; // 14 days free
        return daysLate > 0 ? daysLate * 5 : 0; // $5 per day fine
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Transaction " + transactionId + ": Member " + memberId + " borrowed Book " + bookId +
                " on " + lendDate + (returnDate == null ? "" : ", returned on " + returnDate + (calculateFine() == 0 ? "" : ", fine to pay " + calculateFine()));
    }
}

