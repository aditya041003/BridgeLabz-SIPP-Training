// 4. Singly Linked List: Inventory Management System
class InventoryManagementSLL {

    // Node definition
    static class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    private Node head;

    /* ---------- CRUD ---------- */
    void addAtBeginning(String name, int id, int qty, double price) {
        Node n = new Node(name, id, qty, price);
        n.next = head;
        head = n;
    }

    void addAtEnd(String name, int id, int qty, double price) {
        Node n = new Node(name, id, qty, price);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 0 || head == null) { addAtBeginning(name, id, qty, price); return; }
        Node cur = head; int idx = 0;
        while (cur.next != null && idx < pos - 1) { cur = cur.next; idx++; }
        Node n = new Node(name, id, qty, price);
        n.next = cur.next;
        cur.next = n;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.itemId == id) { head = head.next; return; }
        Node cur = head;
        while (cur.next != null && cur.next.itemId != id) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
    }

    Node searchById(int id) {
        Node cur = head;
        while (cur != null && cur.itemId != id) cur = cur.next;
        return cur;
    }

    Node searchByName(String name) {
        Node cur = head;
        while (cur != null && !cur.itemName.equalsIgnoreCase(name)) cur = cur.next;
        return cur;
    }

    void updateQuantity(int id, int newQty) {
        Node n = searchById(id);
        if (n != null) n.quantity = newQty;
    }

    /* ---------- Aggregate ops ---------- */
    double totalValue() {
        double sum = 0;
        Node cur = head;
        while (cur != null) {
            sum += cur.quantity * cur.price;
            cur = cur.next;
        }
        return sum;
    }

    /* ---------- Sorting using Merge Sort ---------- */
    Node sortedMerge(Node a, Node b, boolean sortByPrice, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        int cmp;
        if (sortByPrice)
            cmp = Double.compare(a.price, b.price);
        else
            cmp = a.itemName.compareToIgnoreCase(b.itemName);

        if (!ascending) cmp = -cmp;

        if (cmp <= 0) {
            a.next = sortedMerge(a.next, b, sortByPrice, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, sortByPrice, ascending);
            return b;
        }
    }

    Node getMiddle(Node h) {
        if (h == null) return h;
        Node slow = h, fast = h.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }

    Node mergeSort(Node h, boolean sortByPrice, boolean ascending) {
        if (h == null || h.next == null) return h;
        Node mid = getMiddle(h);
        Node nextOfMid = mid.next;
        mid.next = null;

        Node left = mergeSort(h, sortByPrice, ascending);
        Node right = mergeSort(nextOfMid, sortByPrice, ascending);

        return sortedMerge(left, right, sortByPrice, ascending);
    }

    void sort(boolean sortByPrice, boolean ascending) {
        head = mergeSort(head, sortByPrice, ascending);
    }

    /* ---------- Display ---------- */
    void display() {
        Node cur = head;
        System.out.println("-- Inventory --");
        while (cur != null) {
            System.out.printf("ID:%d  Name:%s  Qty:%d  Price:%.2f%n",
                    cur.itemId, cur.itemName, cur.quantity, cur.price);
            cur = cur.next;
        }
        System.out.printf("Total Value: %.2f%n", totalValue());
    }

    public static void main(String[] args) {
        InventoryManagementSLL inv = new InventoryManagementSLL();
        inv.addAtEnd("Pen", 101, 10, 5);
        inv.addAtEnd("Notebook", 102, 20, 15);
        inv.addAtBeginning("Pencil", 103, 30, 2);
        inv.display();

        System.out.println("Sorted by Name DESC:");
        inv.sort(false, false);
        inv.display();
    }
}