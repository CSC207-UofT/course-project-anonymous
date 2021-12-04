import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Entites.Airline;
import Entites.Flight;
import UseCases.helpers.FlightFilter;
import org.junit.*;


import java.util.ArrayList;

import UseCases.managers.*;
import UseCases.factories.*;
import UseCases.helpers.*;
import Entites.*;
import java.time.LocalDateTime;
import java.time.LocalDate;


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
    AirlinesManager airlinesManager;
    LocalDateTime date3 = LocalDateTime.of(2020, 05, 1, 14, 30);
    LocalDateTime date4 = LocalDateTime.of(2020, 05, 10, 18, 30);

    @Before
    public void initializeManager(){
        transactionManager = new TransactionManager();
        passenger = new Passenger(123,"Avnish", "abcd@mail.com","12436");
        seat = new EconomySeat(111, 200);
        meal = new Meal("Cake",10.2,13.3,true);
        cabin1 = new CabinBaggage(12.1,11.1,32.0);
        cabin2 = new CabinBaggage(10.2,3.3,4.3);
        checked_in1 = new CabinBaggage(13.4,5.3,15.8);
        checked_in2 = new CabinBaggage(5.5,4.5,11.3);
        checked_in3 = new CabinBaggage(7.4,6.3,10.9);
        baggages.add(cabin1);
        baggages.add(cabin2);
        baggages.add(checked_in1);
        baggages.add(checked_in2);
        baggages.add(checked_in3);
        airlinesManager.addAirline("Air India");
        flight1 = new Flight(date3, date4,"Delhi","Toronto",10.5, airlinesManager.getAirline("Air India"));
        ticket1 = new Ticket(passenger, flight1, seat,false);

    }

    @Test
    public void testTransactionManager()
    {
        Transaction test1 = transactionManager.createTransactionForNewTicket(passenger, seat, meal, baggages);
        assert(test1 instanceof Transaction);

        Transaction test2 = transactionManager.createTransactionRefundTicket(ticket1);
        assert(test2 instanceof Transaction);

        Transaction test3 = transactionManager.createTransactionRescheduleTicket(ticket1, flight1);
        assert(test3 instanceof Transaction);

        transactionManager.addTransaction(test1);
        transactionManager.remove(test1);

    }

    }

