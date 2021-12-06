package UseCases.helpers;

import Entites.Passenger;
import Entites.Ticket;
import UseCases.managers.*;

import java.util.ArrayList;

public class TicketFilter {
    /**
     * Filters the tickets for this passenger
     * @param ticketManager a TicketManager object
     * @param passenger a Passenger object
     * @return a list of tickets booked by this passenger
     */
    public ArrayList<Ticket> getTicketsForPassenger(TicketManager ticketManager, Passenger passenger) {

        // Creating an ArrayList to store the tickets
        ArrayList<Ticket> tickets_so_far = new ArrayList<>();

        // Returns all tickets booked by a single passenger
        for (Ticket ticket : ticketManager) {
            if (ticket.getPassenger().getId() == passenger.getId()) {
                tickets_so_far.add(ticket);
            }
        }

        // Returning an ArrayList of all tickets booked by a particular passenger
        return tickets_so_far;
    }
}
