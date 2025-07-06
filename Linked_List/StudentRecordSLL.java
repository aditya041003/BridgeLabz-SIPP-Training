// 1. Singly Linked List: Student Record Management
class StudentRecordSLL {

    // Node definition
    static class Node {
        int roll;
        String name;
        int age;
        String grade;
        Node next;

        Node(int roll, String name, int age, String grade) {
            this.roll = roll;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    private Node head;

    // ------------- CRUD OPERATIONS -------------
    // Add student at beginning
    void addAtBeginning(int roll, String name, int age, String grade) {
        Node newNode = new Node(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add student at end
    void addAtEnd(int roll, String name, int age, String grade) {
        Node newNode = new Node(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    // Add student at specific position (0‑based index)
    void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 0 || head == null) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Node curr = head;
        int idx = 0;
        while (curr.next != null && idx < pos - 1) {
            curr = curr.next;
            idx++;
        }
        Node newNode = new Node(roll, name, age, grade);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    // Delete student by roll number
    void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null && curr.next.roll != roll) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
    }

    // Search student by roll number
    Node search(int roll) {
        Node curr = head;
        while (curr != null && curr.roll != roll) curr = curr.next;
        return curr;
    }

    // Update grade by roll number
    void updateGrade(int roll, String newGrade) {
        Node n = search(roll);
        if (n != null) n.grade = newGrade;
    }

    // Display all students
    void display() {
        Node curr = head;
        System.out.println("-- Student Records --");
        while (curr != null) {
            System.out.printf("Roll: %d  Name: %s  Age: %d  Grade: %s%n",
                    curr.roll, curr.name, curr.age, curr.grade);
            curr = curr.next;
        }
    }

    // Demo
    public static void main(String[] args) {
        StudentRecordSLL list = new StudentRecordSLL();
        list.addAtEnd(1, "Alice", 20, "A");
        list.addAtEnd(2, "Bob", 21, "B");
        list.addAtBeginning(3, "Charlie", 19, "B+");
        list.addAtPosition(1, 4, "David", 22, "C");
        list.display();

        System.out.println("Deleting roll 2...");
        list.deleteByRoll(2);
        list.display();

        System.out.println("Updating grade for roll 4...");
        list.updateGrade(4, "A-");
        list.display();

        Node found = list.search(1);
        if (found != null)
            System.out.println("Found: " + found.name + " (Roll " + found.roll + ")");
    }
}