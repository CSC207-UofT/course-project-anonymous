import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Memberships.Seats.EconomySeat;
import Entites.Users.Passenger;
import org.junit.*;
import UseCases.helpers.*;
import Entites.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestNewTicketTransactionCreator {
    /**
     * This class tests the NewTicketTransactionCreator
     * class for its functionality of producing the correct Transaction
     * according to the given arguments
     */
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
    assertEquals(newTicketTransactionCreator.getTransaction(passenger, seat, meal, bagages).calculateTotal(), 94.0,1);
    }
}

