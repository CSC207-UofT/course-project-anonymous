import java.util.ArrayList;

public class TicketManager {
    ArrayList<Ticket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }

    public Ticket addTicket(Passenger passenger, Flight flight, Seat seat, Meal meal, ArrayList<Baggage> baggages) {
        Ticket ticket = new Ticket(passenger, flight, seat, meal, baggages);
        this.tickets.add(ticket);
        // TODO: implement observable-observer design pattern to make the seat occupied and add points to passenger
        return ticket;
    }

    // TODO: implement methods to decrease methods in Ticket
}
