// 2. Doubly Linked List: Movie Management System
class MovieManagementDLL {

    // Node definition
    static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node prev, next;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    private Node head, tail;

    // Add movie at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Node n = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    // Add movie at end
    void addAtEnd(String title, String director, int year, double rating) {
        Node n = new Node(title, director, year, rating);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    // Add movie at position (0‑based)
    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Node curr = head;
        int idx = 0;
        while (curr.next != null && idx < pos - 1) {
            curr = curr.next;
            idx++;
        }
        Node n = new Node(title, director, year, rating);
        n.next = curr.next;
        n.prev = curr;
        if (curr.next != null) curr.next.prev = n;
        else tail = n;
        curr.next = n;
    }

    // Remove movie by title
    void removeByTitle(String title) {
        Node curr = head;
        while (curr != null && !curr.title.equalsIgnoreCase(title)) curr = curr.next;
        if (curr == null) return;
        if (curr.prev != null) curr.prev.next = curr.next;
        else head = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;
        else tail = curr.prev;
    }

    // Search by director
    Node searchByDirector(String director) {
        Node curr = head;
        while (curr != null && !curr.director.equalsIgnoreCase(director)) curr = curr.next;
        return curr;
    }

    // Search by rating
    Node searchByRating(double rating) {
        Node curr = head;
        while (curr != null && curr.rating != rating) curr = curr.next;
        return curr;
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        Node curr = head;
        while (curr != null && !curr.title.equalsIgnoreCase(title)) curr = curr.next;
        if (curr != null) curr.rating = newRating;
    }

    // Display forward
    void displayForward() {
        System.out.println("-- Movies (Forward) --");
        Node curr = head;
        while (curr != null) {
            System.out.printf("%s (%d) Dir:%s Rating:%.1f%n",
                    curr.title, curr.year, curr.director, curr.rating);
            curr = curr.next;
        }
    }

    // Display reverse
    void displayReverse() {
        System.out.println("-- Movies (Reverse) --");
        Node curr = tail;
        while (curr != null) {
            System.out.printf("%s (%d) Dir:%s Rating:%.1f%n",
                    curr.title, curr.year, curr.director, curr.rating);
            curr = curr.prev;
        }
    }

    // Demo
    public static void main(String[] args) {
        MovieManagementDLL list = new MovieManagementDLL();
        list.addAtEnd("Inception", "Nolan", 2010, 9.0);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        list.addAtBeginning("Memento", "Nolan", 2000, 8.5);
        list.displayForward();

        System.out.println("Update rating for Inception");
        list.updateRating("Inception", 9.2);
        list.displayForward();

        System.out.println("Reverse order:");
        list.displayReverse();
    }
}