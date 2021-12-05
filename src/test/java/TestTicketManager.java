import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import UseCases.managers.*;
import Entites.*;


public class TestTicketManager {
    TicketManager ticketManager;

    @Before
    public void  initializeManager(){
        ticketManager = new TicketManager();
    }

    @Test
    public void testAddTicket() {
        LocalDateTime depart = LocalDateTime.of(2021, 06, 15, 19, 30);
        LocalDateTime arrive = LocalDateTime.of(2021, 06, 15, 21, 30);
        Airline airline = new Airline("AC");
        Flight flight = new Flight(depart, arrive, "TOR", "VAN", 5, airline);
        Seat seat = new FirstClassSeat(12, 1500);
        Meal meal = new Meal("Sushi", 800, 15, false);
        Baggage cbaggage = new CabinBaggage(12, 13, 14);
        Passenger passenger = new Passenger(12, "Kevin", "a@email", "1234");

        ArrayList<Baggage> baggages = new ArrayList<>();
        baggages.add(cbaggage);

        assert (ticketManager.getTickets().size() == 0);
        Ticket newtest = ticketManager.addTicket(passenger, flight, seat, meal, baggages, false);
        assertTrue(newtest instanceof Ticket);
    }
    // check if a ticket was created for proper functionality
}