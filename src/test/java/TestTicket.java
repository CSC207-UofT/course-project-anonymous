import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TestTicket {
    Ticket ticket;

    @Before
    public void initializeManager(){
        Passenger passenger = new Passenger(1, "Kevin", "hello", "123");

        LocalDateTime depart = LocalDateTime.of(2021, 06, 15, 19, 30);
        LocalDateTime arrive = LocalDateTime.of(2021, 06, 15, 21, 30);
        Airline airline = new Airline("AC");
        Flight flight = new Flight(depart, arrive, "TOR", "VAN", 5, airline);
        Seat seat = new FirstClassSeat(1, 1500);
        ticket = new Ticket(passenger, flight, seat, false);
    }
    @Test
    public void TestgetPassenger() {
        Passenger passenger = new Passenger(1, "Kevin", "hello", "123");
        LocalDateTime depart = LocalDateTime.of(2021, 06, 15, 19, 30);
        LocalDateTime arrive = LocalDateTime.of(2021, 06, 15, 21, 30);
        Airline airline = new Airline("AC");
        Flight flight = new Flight(depart, arrive, "TOR", "VAN", 5, airline);
        Seat seat = new FirstClassSeat(1, 1500);
        ticket = new Ticket(passenger, flight, seat, false);
        assertEquals(passenger, ticket.getPassenger());
    }
    @Test
    public void Testgetflight() {
        Passenger passenger = new Passenger(1, "Kevin", "hello", "123");
        LocalDateTime depart = LocalDateTime.of(2021, 06, 15, 19, 30);
        LocalDateTime arrive = LocalDateTime.of(2021, 06, 15, 21, 30);
        Airline airline = new Airline("AC");
        Flight flight = new Flight(depart, arrive, "TOR", "VAN", 5, airline);
        Seat seat = new FirstClassSeat(1, 1500);
        ticket = new Ticket(passenger, flight, seat, false);
        assertEquals(flight, ticket.getFlight());
    }
    @Test
    public void Testgetseat() {
        Passenger passenger = new Passenger(1, "Kevin", "hello", "123");
        LocalDateTime depart = LocalDateTime.of(2021, 06, 15, 19, 30);
        LocalDateTime arrive = LocalDateTime.of(2021, 06, 15, 21, 30);
        Airline airline = new Airline("AC");
        Flight flight = new Flight(depart, arrive, "TOR", "VAN", 5, airline);
        Seat seat = new FirstClassSeat(1, 1500);
        ticket = new Ticket(passenger, flight, seat, false);
        assertEquals(seat, ticket.getSeat());
    }
}
