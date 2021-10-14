import java.util.ArrayList;

public class TicketManager {
    ArrayList<Ticket> tickets;

    public TicketManager() {
        this.tickets = new ArrayList<>();
    }

    public Ticket addTicket(Passenger passenger, Flight flight, Seat seat, Meal meal, ArrayList<Baggage> baggages) {
        Ticket ticket = new Ticket(passenger, flight, seat, meal, baggages);
        this.tickets.add(ticket);
        return ticket;
    }
}
