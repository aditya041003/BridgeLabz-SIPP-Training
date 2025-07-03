// Sample Program 2 – Library Management System
class Book {
    private static String libraryName = "City Public Library";

    private final String isbn;
    private String title;
    private String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn + " | Title: " + title + " | Author: " + author);
        }
    }

    public static void main(String[] args) {
        Book b = new Book("978-0135166307", "Effective Java", "Joshua Bloch");
        Book.displayLibraryName();
        b.displayDetails();
    }
}