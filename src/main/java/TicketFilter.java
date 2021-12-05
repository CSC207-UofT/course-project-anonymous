import java.util.ArrayList;

public class TicketFilter {
    /**
     * Filters the tickets for this passenger
     * @param ticketManager a TicketManager object
     * @param passenger a Passenger object
     * @return a list of tickets booked by this passenger
     */
    ArrayList<Ticket> getTicketsForPassenger(TicketManager ticketManager, Passenger passenger) {
        ArrayList<Ticket> tickets_so_far = new ArrayList<>();

        for (Ticket ticket : ticketManager) {
            if (ticket.getPassenger().getId() == passenger.getId()) {
                tickets_so_far.add(ticket);
            }
        }

        return tickets_so_far;
    }
}
