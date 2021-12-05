import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestNewTicketTransactionCreator {
    NewTicketTransactionCreator newTicketTransactionCreator;
    Passenger passenger;
    EconomySeat seat;
    Meal meal;
    CabinBaggage cabinBaggage;
    ArrayList<Baggage> bagages;

    @Before
    public void initializeManager() {
        newTicketTransactionCreator = new NewTicketTransactionCreator();
        passenger = new Passenger(1, "Dixshant", "dix.4@gmail.com", "1234567");
        seat = new EconomySeat(1, 100);
        meal = new Meal("Sushi", 100, 5, false);
        cabinBaggage = new CabinBaggage(1,1,1);
        bagages = new ArrayList<>();
        bagages.add(cabinBaggage);
    }
    @Test
    public void testGetTransaction(){
    assertEquals(newTicketTransactionCreator.getTransaction(passenger, seat, meal, bagages).calculateTotal(), 94.0,0);
    }
}

