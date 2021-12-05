import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class TestRescheduleTicketTransactionCreator {
    RescheduleTicketTransactionCreator rescheduleTicketTransactionCreator;
    Ticket ticket;
    Flight flight;
    Passenger passenger;
    LocalDateTime date1 = LocalDateTime.of(2020, 05, 10, 19, 30);
    LocalDateTime date2 = LocalDateTime.of(2020, 05, 10, 21, 30);
    Airline airline;
    Flight flight1;
    CabinBaggage cabinBaggage;
    ArrayList<Baggage> bagages;
    @Before
    public void initializeManager() {
        rescheduleTicketTransactionCreator = new RescheduleTicketTransactionCreator();
        passenger = new Passenger(1, "Dixshant", "dix.4@gmail.com", "1234567");
        airline = new Airline("Air Indigo");
        flight = new Flight(date1, date2, "Delhi", "Toronto", 10, airline);
        flight1 = new Flight(date1, date2, "Singapore", "Toronto", 10, airline);
        ticket = new Ticket(passenger, flight, flight.getSeatAtIndex(0), true);
        cabinBaggage = new CabinBaggage(1,1,1);
        bagages = new ArrayList<>();
        bagages.add(cabinBaggage);
        ticket.setBaggages(bagages);
        ticket.setMeal(new Meal("Sushi", 100, 5, false));
    }
    @Test
    public void testgetTransaction(){
        assertEquals(rescheduleTicketTransactionCreator.getTransaction(ticket,flight1).calculateTotal(), 0,0);
    }
}
