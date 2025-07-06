// 6. Circular Linked List: Round Robin Scheduling
class RoundRobinSchedulerCLL {

    static class Node {
        int pid;
        int burst;
        int priority;
        int remaining;
        Node next;
        Node(int id, int burst, int pr) { pid = id; this.burst = burst; remaining = burst; priority = pr; }
    }

    private Node head;

    void addProcess(int id, int burst, int pr) {
        Node n = new Node(id, burst, pr);
        if (head == null) {
            head = n; n.next = n; return;
        }
        Node cur = head;
        while (cur.next != head) cur = cur.next;
        cur.next = n; n.next = head;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.pid == id && head.next == head) { head = null; return; }
        Node prev = head, cur = head.next;
        if (head.pid == id) {
            while (prev.next != head) prev = prev.next;
            prev.next = head.next; head = head.next; return;
        }
        while (cur != head && cur.pid != id) { prev = cur; cur = cur.next; }
        if (cur != head) prev.next = cur.next;
    }

    void simulate(int quantum) {
        if (head == null) return;
        int time = 0;
        Node cur = head;
        double totalTAT = 0, totalWT = 0;
        while (head != null) {
            cur.remaining -= quantum;
            time += quantum;
            System.out.printf("Process %d executes for %d, remaining %d%n", cur.pid, quantum, Math.max(0, cur.remaining));
            Node next = cur.next;

            if (cur.remaining <= 0) {
                int tat = time; // turnaround = finish time - arrival (arrival=0 for simplicity)
                int wt = tat - cur.burst;
                totalTAT += tat; totalWT += wt;
                System.out.printf("Process %d finished. TAT=%d WT=%d%n", cur.pid, tat, wt);
                removeById(cur.pid);
            }
            cur = head == null ? null : next;
        }
        int n = 3; // hard‑coded demo size
        System.out.printf("Avg WT=%.2f  Avg TAT=%.2f%n", totalWT / n, totalTAT / n);
    }

    void displayQueue() {
        if (head == null) { System.out.println("Queue empty"); return; }
        Node cur = head;
        System.out.print("Queue: ");
        do {
            System.out.print(cur.pid + "(" + cur.remaining + ") ");
            cur = cur.next;
        } while (cur != head);
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinSchedulerCLL rr = new RoundRobinSchedulerCLL();
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 15, 1);
        rr.addProcess(3, 5, 1);
        rr.displayQueue();
        rr.simulate(5);
    }
}