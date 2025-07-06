class Ticket {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int id, String customer, String movie, String seat, String time) {
        ticketId = id;
        customerName = customer;
        movieName = movie;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

public class TicketReservationCLL {
    private Ticket last = null;

    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
    }

    public void removeTicket(int id) {
        if (last == null) return;
        Ticket curr = last.next, prev = last;
        do {
            if (curr.ticketId == id) {
                if (curr == last && curr == last.next) {
                    last = null;
                } else {
                    prev.next = curr.next;
                    if (curr == last) last = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != last.next);
    }

    public void displayTickets() {
        if (last == null) return;
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                               ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public int countTickets() {
        if (last == null) return 0;
        int count = 0;
        Ticket temp = last.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);
        return count;
    }

    public static void main(String[] args) {
        TicketReservationCLL tr = new TicketReservationCLL();
        tr.addTicket(101, "Alice", "Inception", "A1", "7PM");
        tr.addTicket(102, "Bob", "Matrix", "B2", "9PM");
        tr.displayTickets();
        System.out.println("Total tickets: " + tr.countTickets());
        tr.removeTicket(101);
        tr.displayTickets();
    }
}