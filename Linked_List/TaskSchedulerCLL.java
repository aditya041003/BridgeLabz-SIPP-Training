// 3. Circular Linked List: Task Scheduler
class TaskSchedulerCLL {

    // Node definition
    static class Node {
        int id;
        String name;
        int priority;
        String due;
        Node next;

        Node(int id, String name, int priority, String due) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.due = due;
        }
    }

    private Node head = null;

    // Add at end
    void addAtEnd(int id, String name, int priority, String due) {
        Node n = new Node(id, name, priority, due);
        if (head == null) {
            head = n;
            n.next = n;
            return;
        }
        Node cur = head;
        while (cur.next != head) cur = cur.next;
        cur.next = n;
        n.next = head;
    }

    // Add at beginning
    void addAtBeginning(int id, String name, int priority, String due) {
        addAtEnd(id, name, priority, due); // reuse
        head = head.next; // new node becomes head
    }

    // Add at position (0‑based)
    void addAtPosition(int pos, int id, String name, int priority, String due) {
        if (head == null || pos <= 0) {
            addAtBeginning(id, name, priority, due);
            return;
        }
        Node cur = head;
        int idx = 0;
        while (cur.next != head && idx < pos - 1) {
            cur = cur.next;
            idx++;
        }
        Node n = new Node(id, name, priority, due);
        n.next = cur.next;
        cur.next = n;
    }

    // Remove by ID
    void removeById(int id) {
        if (head == null) return;
        Node cur = head, prev = null;
        do {
            if (cur.id == id) {
                if (prev == null) { // head node
                    // only one node
                    if (head.next == head) { head = null; return; }
                    // find last node
                    Node last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }

    // Search by priority (returns first match)
    Node searchPriority(int pr) {
        if (head == null) return null;
        Node cur = head;
        do {
            if (cur.priority == pr) return cur;
            cur = cur.next;
        } while (cur != head);
        return null;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("-- Task List --");
        Node cur = head;
        do {
            System.out.printf("ID:%d Name:%s Priority:%d Due:%s%n",
                    cur.id, cur.name, cur.priority, cur.due);
            cur = cur.next;
        } while (cur != head);
    }

    // Demo
    public static void main(String[] args) {
        TaskSchedulerCLL ts = new TaskSchedulerCLL();
        ts.addAtEnd(1, "Task1", 1, "2025-07-10");
        ts.addAtEnd(2, "Task2", 2, "2025-07-11");
        ts.addAtBeginning(3, "Task3", 1, "2025-07-09");
        ts.addAtPosition(1, 4, "Task4", 3, "2025-07-12");
        ts.display();

        System.out.println("Removing Task ID 2");
        ts.removeById(2);
        ts.display();

        TaskSchedulerCLL.Node found = ts.searchPriority(3);
        if (found != null)
            System.out.println("Found high priority task: " + found.name);
    }
}