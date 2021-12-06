package UseCases.managers;

import Entites.Flight;
import Entites.Memberships.Seats.Seat;
import Entites.Ticket;

public class RescheduleManager {



    /**
     * Reschedule the ticket of a passanger
     * @param ticket input the old ticket details of the passanger
     * @param flight input the new flight details
     * @param ticketManager object to call functions to help reschedule the ticket to a new ticket
     */
    public void reschedule(Ticket ticket, Flight flight, TicketManager ticketManager) {


        Seat oldSeat = ticket.getSeat();
        int seatIndex = ticket.getFlight().getSeatNo(oldSeat);
        Seat newSeat = flight.getSeatAtIndex(seatIndex);

        ticketManager.addTicket(ticket.getPassenger(), flight, newSeat, ticket.getMeal(), ticket.getBaggages(), false);
    }
}
