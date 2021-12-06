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

    /**
     * Booking System collects all the components need to book a ticket and show transactions,
     * and books a ticket and has some helper functions.
     */
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

    /**
     * Returns all the flights which are going from and to the same flight as in the ticket given
     * @param ticketInfo Map containing information of the ticket
     * @return An arraylist of Map containing information about flights similar to the flight in the ticket
     */
    public ArrayList<Map<String, String>> getSimilarFlight(Map<String, String> ticketInfo) {
        FlightFilter flightFilter = new FlightFilter();
        FlightFactory flightFactory = new FlightFactory();

        String flightName = ticketInfo.get("airlineName") + "-" + ticketInfo.get("flightId");
        return flightFactory.getFlightsInfo(flightFilter.getSimilarFlights(this.airlinesManager,
                this.airlinesManager.getFlightByName(flightName)));
    }

    /**
     * Get all the tickets booked b a passenger
     * @param passengerInfo A map containing information of passenger
     * @return A list of Map of information of tickets booked
     */
    public ArrayList<Map<String, String>> getTicketsForPassenger(Map<String, String> passengerInfo) {
        TicketFilter ticketFilter = new TicketFilter();
        TicketFactory ticketFactory = new TicketFactory();

        return ticketFactory.getTicketsInfo(ticketFilter.getTicketsForPassenger(this.ticketManager, passengerInfo));
    }

    /**
     * Return Creates a rescheduled translation
     * @param ticketInfo Ticket of the flight needed to be rescheduled
     * @param flightName Name of the flight to reschedule to.
     * @return A Map containing information of the transaction
     */
    public Map<String, Double> getRescheduleTransactionInfo(Map<String, String> ticketInfo, String flightName) {
        return this.transactionManager.createTransactionRescheduleTicket(ticketManager.getTicketFromInfo(ticketInfo),
                airlinesManager.getFlightByName(flightName)).getItems();
    }

    /**
     * Return Creates a refund translation
     * @param ticketInfo Ticket of the flight needed to be refunded
     * @return A Map containing information of the transaction
     */
    public Map<String, Double> getRefundTransactionInfo(Map<String, String> ticketInfo) {
        return this.transactionManager.createTransactionRefundTicket(ticketManager.getTicketFromInfo(ticketInfo)).getItems();
    }

    /**
     * Create a new booking transaction
     * @param passengerId Id of the passenger
     * @param flightName name of the flight to book
     * @param seatId id of the seat on the flight to book
     * @param mealName meal selected
     * @param baggages list of baggages
     * @return A map containing information of the transaction
     */
    public Map<String, Double> getNewTicketTransactionInfo(int passengerId, String flightName,
                                                           int seatId, String mealName, ArrayList<Map<String, Double>> baggages) {
        BaggageFactory baggageFactory = new BaggageFactory();

        return transactionManager.createTransactionForNewTicket(passengerManager.getPassengerWithId(passengerId),
                airlinesManager.getFlightByName(flightName).getSeatAtIndex(seatId),
                mealsManager.getMeal(mealName),
                baggageFactory.createBaggageList(baggages)).getItems();
    }

    /**
     * Reschedules a flight
     * @param ticketInfo Ticket of the flight needed to be rescheduled
     * @param flightName Name of the flight to reschedule to.
     */
    public void reschedule(Map<String, String> ticketInfo, String flightName) {
        this.rescheduleManager.reschedule(ticketManager.getTicketFromInfo(ticketInfo),
                airlinesManager.getFlightByName(flightName), this.ticketManager);
    }

    /**
     * Returns the seat map of a flight
     * @param flightName name of the flight
     * @param seatClass class of the seat (Economy, Business or First)
     */
    public ArrayList<Boolean> getSeatMap(String flightName, String seatClass) {
        SeatFactory seatFactory = new SeatFactory();
        return seatFactory.getSeatSymbols(this.airlinesManager.getSeatsOfClass(flightName, seatClass));
    }

    /**
     * Book a new ticket
     * @param passengerId Id of the passenger
     * @param flightName name of the flight to book
     * @param seatId id of the seat on the flight to book
     * @param mealName meal selected
     * @param baggages list of baggages
     * @return Map containing information of the ticket
     */
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
