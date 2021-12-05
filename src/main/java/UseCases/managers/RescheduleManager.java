package UseCases.managers;

import Entites.Flight;
import Entites.Seat;
import Entites.Ticket;

public class RescheduleManager {
    public void reschedule(Ticket ticket, Flight flight, TicketManager ticketManager) {

        Seat oldSeat = ticket.getSeat();
        int seatIndex = ticket.getFlight().getSeatNo(oldSeat);
        Seat newSeat = flight.getSeatAtIndex(seatIndex);

        ticketManager.addTicket(ticket.getPassenger(), flight, newSeat, ticket.getMeal(), ticket.getBaggages(), false);
    }
}
