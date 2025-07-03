// Problem 5 – Library Management System
abstract class LibraryItemLM {
    private int itemId;
    private String title;
    private String author;
    LibraryItemLM(int id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }
    public void getItemDetails() { System.out.println("ID:" + itemId + " Title:" + title + " Author:" + author); }
    public abstract int getLoanDuration(); // days
}

interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

class BookLM extends LibraryItemLM implements Reservable {
    private boolean reserved = false;
    BookLM(int id, String title, String author) { super(id, title, author); }
    @Override public int getLoanDuration() { return 14; }
    @Override public boolean reserveItem() { reserved = true; return true; }
    @Override public boolean checkAvailability() { return !reserved; }
}

class MagazineLM extends LibraryItemLM implements Reservable {
    private boolean reserved = false;
    MagazineLM(int id, String title, String author) { super(id, title, author); }
    @Override public int getLoanDuration() { return 7; }
    @Override public boolean reserveItem() { reserved = true; return true; }
    @Override public boolean checkAvailability() { return !reserved; }
}

class DVDLM extends LibraryItemLM implements Reservable {
    private boolean reserved = false;
    DVDLM(int id, String title, String author) { super(id, title, author); }
    @Override public int getLoanDuration() { return 3; }
    @Override public boolean reserveItem() { reserved = true; return true; }
    @Override public boolean checkAvailability() { return !reserved; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItemLM[] items = {
            new BookLM(1, "1984", "Orwell"),
            new MagazineLM(2, "National Geographic", "Various"),
            new DVDLM(3, "Inception", "Nolan")
        };
        for (LibraryItemLM item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days | Available: "
                               + ((Reservable) item).checkAvailability());
            ((Reservable) item).reserveItem();
        }
    }
}