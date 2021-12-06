import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Seats.EconomySeat;
import Entites.Users.Passenger;
import UseCases.factories.PassengerFactory;
import org.junit.*;
import UseCases.helpers.*;
import UseCases.managers.*;
import Entites.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class TestTicketFIlter {
    /**
     * This test class is testing the TicketFilter in its
     * functionality of being able to successfully filter
     * the tickets based on the passengers id
     */
    TicketFilter ticketFilter;
    TicketManager ticketManager;
    Passenger passenger;
    Passenger passenger1;
    Flight flight;
    EconomySeat seat;
    Meal meal;
    Ticket ticket;
    CabinBaggage cabinBaggage;
    ArrayList<Baggage> bagages;
    LocalDateTime date1 = LocalDateTime.of(2020, 05, 10, 19, 30);
    LocalDateTime date2 = LocalDateTime.of(2020, 05, 10, 21, 30);
    Airline airline;
    @Before
    public void initializeManager() {
        ticketFilter = new TicketFilter();
        ticketManager = new TicketManager();
        passenger = new Passenger(1, "Dix", "dix4@gmail.com", "1234567");
        passenger1 = new Passenger(2, "Dix2", "dix4@gmail.com", "1234567");
        airline = new Airline("Air Indigo");
        flight = new Flight(date1, date2, "Delhi", "Toronto", 10, airline);
        seat = new EconomySeat(1, 100);
        meal = new Meal("Sushi", 100, 5, false);
        cabinBaggage = new CabinBaggage(1,1,1);
        bagages = new ArrayList<>();
        bagages.add(cabinBaggage);
        ticket = new Ticket(passenger, flight, seat, true);
        ticketManager.addTicket(passenger, flight, seat, meal, bagages, true);
        ticketManager.addTicket(passenger1, flight, seat, meal, bagages, true);
    }

    @Test
    public void testgetTicketsForPassenger(){
        PassengerFactory passengerFactory =  new PassengerFactory();
        Map<String, String> passengerInfo = passengerFactory.getPassengerInfo(passenger);

        assertEquals(ticketFilter.getTicketsForPassenger(ticketManager, passengerInfo).get(0).getPassenger().getName(), "Dix" );
        assertEquals(ticketFilter.getTicketsForPassenger(ticketManager, passengerInfo).size(), 1 );

    }
}
