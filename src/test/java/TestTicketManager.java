import java.time.LocalDateTime;
import java.util.ArrayList;

import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Seats.FirstClassSeat;
import Entites.Seats.Seat;
import Entites.Users.Passenger;
import org.junit.Before;
import org.junit.Test;

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
        Passenger passenger2 = new Passenger(11, "Avnish", "p@email", "7263");

        ArrayList<Baggage> baggages = new ArrayList<>();
        baggages.add(cbaggage);

        // Checking that currently our system has 0 tickets
        assert (ticketManager.getTickets().size() == 0);

        // Creating new tickets
        ticketManager.addTicket(passenger, flight, seat, meal, baggages, false);
        ticketManager.addTicket(passenger2, flight, seat, meal, baggages, false);

        assert (ticketManager.getTickets().size() == 2);

    }
}
