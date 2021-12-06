import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Baggages.CheckInBaggage;
import Entites.Seats.EconomySeat;
import Entites.Seats.Seat;
import Entites.Users.Passenger;
import UseCases.helpers.RefundTransactionCreator;
import org.junit.Before;
import org.junit.Test;
import Entites.Flight;
import UseCases.managers.*;
import Entites.*;


public class TestRefundTransactionCreator {
    RefundTransactionCreator refundTransactionCreator;
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
    LocalDate date1 = LocalDate.of(2020, 05, 10);
    LocalDate date2 = LocalDate.of(2020, 06, 11);
    LocalDateTime date3 = LocalDateTime.of(2020, 05, 1, 14, 30);
    LocalDateTime date4 = LocalDateTime.of(2020, 05, 10, 18, 30);
    LocalDate date5 = LocalDate.of(2020, 05, 10);
    LocalDate date6 = LocalDate.of(2021, 12, 22);

    @Before
    public void initializeManager(){
        /**
         * Initializing the data members and putting some generated/default values in them (for testing purposes).
         */
        refundTransactionCreator = new RefundTransactionCreator();
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
    public void testRefundTransactionCreator(){

        // Testing the getTransaction function
        Transaction test1 = refundTransactionCreator.getTransaction(ticket1);
        assert (test1 instanceof Transaction);
    }

    @Test
    public void testRefundTransactionCreator2(){

        // Testing if the getDifferenceDays returns the correct difference in days
        long test2 = refundTransactionCreator.getDifferenceDays(date1, date2);
        assert (test2 == 32);

        // Testing if the getDifferenceDays returns the correct difference in days
        long test3 = refundTransactionCreator.getDifferenceDays(date5, date6);
        assert (test3 == 591);

    }

}
