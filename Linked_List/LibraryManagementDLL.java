// 5. Doubly Linked List: Library Management System
class LibraryManagementDLL {

    static class Node {
        String title, author, genre;
        int id;
        boolean available;
        Node prev, next;
        Node(String t, String a, String g, int id, boolean avail) {
            title = t; author = a; genre = g; this.id = id; available = avail;
        }
    }
    private Node head, tail;

    void addAtBeginning(String t, String a, String g, int id, boolean av) {
        Node n = new Node(t, a, g, id, av);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
    }
    void addAtEnd(String t, String a, String g, int id, boolean av) {
        Node n = new Node(t, a, g, id, av);
        if (tail == null) head = tail = n;
        else { tail.next = n; n.prev = tail; tail = n; }
    }
    void addAtPosition(int pos, String t, String a, String g, int id, boolean av) {
        if (pos <= 0 || head == null) { addAtBeginning(t, a, g, id, av); return; }
        Node cur = head; int idx = 0;
        while (cur.next != null && idx < pos - 1) { cur = cur.next; idx++; }
        Node n = new Node(t, a, g, id, av);
        n.next = cur.next; n.prev = cur;
        if (cur.next != null) cur.next.prev = n; else tail = n;
        cur.next = n;
    }
    void removeById(int id) {
        Node cur = head;
        while (cur != null && cur.id != id) cur = cur.next;
        if (cur == null) return;
        if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
    }
    Node searchByTitle(String title) {
        Node cur = head;
        while (cur != null && !cur.title.equalsIgnoreCase(title)) cur = cur.next;
        return cur;
    }
    Node searchByAuthor(String author) {
        Node cur = head;
        while (cur != null && !cur.author.equalsIgnoreCase(author)) cur = cur.next;
        return cur;
    }
    void updateAvailability(int id, boolean av) {
        Node cur = head;
        while (cur != null && cur.id != id) cur = cur.next;
        if (cur != null) cur.available = av;
    }
    void displayForward() {
        System.out.println("-- Library (Forward) --");
        Node c = head;
        while (c != null) {
            System.out.printf("%s | %s | %s | %d | %s%n",
                    c.title, c.author, c.genre, c.id, c.available ? "Available" : "Issued");
            c = c.next;
        }
    }
    void displayReverse() {
        System.out.println("-- Library (Reverse) --");
        Node c = tail;
        while (c != null) {
            System.out.printf("%s | %s | %s | %d | %s%n",
                    c.title, c.author, c.genre, c.id, c.available ? "Available" : "Issued");
            c = c.prev;
        }
    }
    int countBooks() {
        int cnt = 0; Node c = head; while (c != null) { cnt++; c = c.next; } return cnt;
    }
    public static void main(String[] args) {
        LibraryManagementDLL lib = new LibraryManagementDLL();
        lib.addAtEnd("Java", "Gosling", "Tech", 1, true);
        lib.addAtEnd("C++", "Bjarne", "Tech", 2, true);
        lib.addAtBeginning("Kite Runner", "Hosseini", "Fiction", 3, true);
        lib.displayForward();
        System.out.println("Total: " + lib.countBooks());
    }
}