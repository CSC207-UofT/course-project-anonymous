import java.time.LocalDateTime;
import java.util.ArrayList;

import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Baggages.CheckInBaggage;
import Entites.Seats.EconomySeat;
import Entites.Seats.Seat;
import Entites.Users.Passenger;
import org.junit.Before;
import org.junit.Test;
import Entites.Flight;
import UseCases.managers.*;
import Entites.*;



public class TestTransactionManager {
    TransactionManager transactionManager;
    Passenger passenger;
    Seat seat;
    Meal meal;
    ArrayList<Baggage> baggages = new ArrayList<>();
    Baggage cabin1;
    Baggage cabin2;
    Baggage checked_in1;
    Baggage checked_in2;
    Baggage checked_in3;
    Ticket ticket1;
    Flight flight1;
    AirlinesManager airlinesManager = new AirlinesManager();
    LocalDateTime date3 = LocalDateTime.of(2020, 05, 1, 14, 30);
    LocalDateTime date4 = LocalDateTime.of(2020, 05, 10, 18, 30);

    @Before
    public void initializeManager(){
        /**
         * Initializing the data members and putting some generated/default values in them (for testing purposes).
         */
        transactionManager = new TransactionManager();
        passenger = new Passenger(123,"Avnish", "abcd@mail.com","12436");
        seat = new EconomySeat(111, 200);
        meal = new Meal("Cake",10.2,13.3,true);
        cabin1 = new CabinBaggage(12.1,11.1,32.0);
        cabin2 = new CabinBaggage(10.2,3.3,4.3);
        checked_in1 = new CheckInBaggage(13.4,5.3,15.8);
        checked_in2 = new CheckInBaggage(5.5,4.5,11.3);
        checked_in3 = new CheckInBaggage(7.4,6.3,10.9);
        baggages.add(cabin1);
        baggages.add(cabin2);
        baggages.add(checked_in1);
        baggages.add(checked_in2);
        baggages.add(checked_in3);
        airlinesManager.addAirline("Air India");
        flight1 = new Flight(date3, date4,"Delhi","Toronto",10.5, airlinesManager.getAirline("Air India"));
        ticket1 = new Ticket(passenger, flight1, flight1.getSeatAtIndex(1), false);
        ticket1.setBaggages(new ArrayList<>());
        ticket1.setMeal(meal);

    }

    @Test
    public void testTransactionManager()
    {
        // Testing the createTransactionForNewTicket method
        Transaction test1 = transactionManager.createTransactionForNewTicket(passenger, seat, meal, baggages);
        assert(test1 instanceof Transaction);

        // Testing the createTransactionRefundTicket method
        Transaction test2 = transactionManager.createTransactionRefundTicket(ticket1);
        assert(test2 instanceof Transaction);

        // Testing the createTransactionRescheduleTicket method
        Transaction test3 = transactionManager.createTransactionRescheduleTicket(ticket1, flight1);
        assert(test3 instanceof Transaction);

        // Testing that a ticket is removed successfully from the system
        transactionManager.remove(test1);

    }

    }

