package UseCases.helpers;

import Entites.Passenger;
import Entites.Ticket;
import UseCases.managers.*;

import java.util.ArrayList;
import java.util.Map;

public class TicketFilter {

    /**
     * Filters the tickets for this passenger
     * @param ticketManager a TicketManager object
     * @param passenger a Passenger object
     * @return a list of tickets booked by this passenger
     */
  
    public ArrayList<Ticket> getTicketsForPassenger(TicketManager ticketManager, Map<String, String> passengerInfo) {


        // Creating an ArrayList to store the tickets
        ArrayList<Ticket> tickets_so_far = new ArrayList<>();

        // Returns all tickets booked by a single passenger
        for (Ticket ticket : ticketManager) {
            if (ticket.getPassenger().getId() == Integer.parseInt(passengerInfo.get("id"))) {
                tickets_so_far.add(ticket);
            }
        }

        // Returning an ArrayList of all tickets booked by a particular passenger
        return tickets_so_far;
    }

    public Ticket getTicketWithInfo(TicketManager ticketManager, Map<String, String> ticketInfo) {
        for (Ticket ticket : ticketManager) {
            if (ticket.getPassenger().getName().equals(ticketInfo.get("passengerName"))) {
                if (ticket.getFlight().getName().equals(ticketInfo.get("flightName"))) {
                    if (("" + ticket.getSeat().getId()).equals(ticketInfo.get("seatNo"))) {
                        return ticket;
                    }
                }
            }
        }
        return null;
    }
}
