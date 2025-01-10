public class Book {

    private static int bookId;
    private static String title;
    private static String author;
    private boolean isAvailable;

    public static int bookCount = 0;

    public Book(String title, String author) {
        this.bookId = ++bookCount;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default: available (true)

    }

    // Getters and Setters
    public int getId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String displayBookDetails() {
        return bookId + ": " + title + " by " + author;
    }


}

