public class Book {
    private static int id;
    private static String title;
    private static String author;
    private boolean isAvailable;

    public static int bookCount = 0;

    public Book(String title, String author) {
        this.id = ++bookCount;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default: available

    }

    // Getters and Setters
    public int getId() {
        return id;
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


    public static void displayBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Book ID: " + id);
        System.out.println("Book Author: " + author);
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String toString() {
        return id + ": " + title + " by " + author;
    }
}

