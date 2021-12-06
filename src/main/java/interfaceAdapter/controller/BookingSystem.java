package interfaceAdapter.controller;

import UseCases.factories.BaggageFactory;
import UseCases.factories.FlightFactory;
import UseCases.factories.SeatFactory;
import UseCases.factories.TicketFactory;
import UseCases.helpers.FlightFilter;
import UseCases.helpers.TicketFilter;
import UseCases.managers.*;
import interfaceAdapter.*;

import java.util.ArrayList;
import java.util.Map;

public class BookingSystem {

     public PassengerManager passengerManager;
     public AirlinesManager airlinesManager;
     public TransactionManager transactionManager;
     public MealsManager mealsManager;
     public RescheduleManager rescheduleManager;
     public TicketManager ticketManager;

     public RandomFlightsGenerator randomFlightsGenerator;
     public RandomMealsGenerator randomMealsGenerator;

    public BookingSystem() {
        this.passengerManager = new PassengerManager();
        this.airlinesManager = new AirlinesManager();
        this.transactionManager = new TransactionManager();
        this.mealsManager = new MealsManager();
        this.rescheduleManager = new RescheduleManager();

        this.ticketManager = new TicketManager();

        this.ticketManager.addObserver(this.passengerManager);

        randomFlightsGenerator = new RandomFlightsGenerator(this.airlinesManager, "2021-11-13");
        randomFlightsGenerator.init();

        randomMealsGenerator = new RandomMealsGenerator(this.mealsManager);
        randomMealsGenerator.init();
    }

    public ArrayList<Map<String, String>> getSimilarFlight(Map<String, String> ticketInfo) {
        FlightFilter flightFilter = new FlightFilter();
        FlightFactory flightFactory = new FlightFactory();

        String flightName = ticketInfo.get("airlineName") + "-" + ticketInfo.get("flightId");
        return flightFactory.getFlightsInfo(flightFilter.getSimilarFlights(this.airlinesManager,
                this.airlinesManager.getFlightByName(flightName)));
    }

    public ArrayList<Map<String, String>> getTicketsForPassenger(Map<String, String> passengerInfo) {
        TicketFilter ticketFilter = new TicketFilter();
        TicketFactory ticketFactory = new TicketFactory();

        return ticketFactory.getTicketsInfo(ticketFilter.getTicketsForPassenger(this.ticketManager, passengerInfo));
    }

    public Map<String, Double> getRescheduleTransactionInfo(Map<String, String> ticketInfo, String flightName) {
        return this.transactionManager.createTransactionRescheduleTicket(ticketManager.getTicketFromInfo(ticketInfo),
                airlinesManager.getFlightByName(flightName)).getItems();
    }

    public Map<String, Double> getRefundTransactionInfo(Map<String, String> ticketInfo) {
        return this.transactionManager.createTransactionRefundTicket(ticketManager.getTicketFromInfo(ticketInfo)).getItems();
    }

    public Map<String, Double> getNewTicketTransactionInfo(int passengerId, String flightName,
                                                           int seatId, String mealName, ArrayList<Map<String, Double>> baggages) {
        BaggageFactory baggageFactory = new BaggageFactory();

        return transactionManager.createTransactionForNewTicket(passengerManager.getPassengerWithId(passengerId),
                airlinesManager.getFlightByName(flightName).getSeatAtIndex(seatId),
                mealsManager.getMeal(mealName),
                baggageFactory.createBaggageList(baggages)).getItems();
    }

    public void reschedule(Map<String, String> ticketInfo, String flightName) {
        this.rescheduleManager.reschedule(ticketManager.getTicketFromInfo(ticketInfo),
                airlinesManager.getFlightByName(flightName), this.ticketManager);
    }

    public ArrayList<Boolean> getSeatMap(String flightName, String seatClass) {
        SeatFactory seatFactory = new SeatFactory();
        return seatFactory.getSeatSymbols(this.airlinesManager.getSeatsOfClass(flightName, seatClass));
    }

    public Map<String, String> bookTicket(int passengerId, String flightName,
                      int seatId, String mealName, ArrayList<Map<String, Double>> baggages) {
        BaggageFactory baggageFactory = new BaggageFactory();

        return ticketManager.addTicket(passengerManager.getPassengerWithId(passengerId),
                airlinesManager.getFlightByName(flightName),
                airlinesManager.getFlightByName(flightName).getSeatAtIndex(seatId),
                mealsManager.getMeal(mealName),
                baggageFactory.createBaggageList(baggages), false);
    }
}
