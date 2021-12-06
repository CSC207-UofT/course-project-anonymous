package interfaceAdapter.gateway;

import Entites.Passenger;
import interfaceAdapter.controller.*;

public class PassengerSessionHandler extends UserSessionHandler {
    /**
     * A subclass of the abstract UserSessionHandler. This class
     * acts as a gateway between the UI and the presenters/controllers
     * relay the information
     */
    public Passenger passenger;
    public BookingSystem bookingSystem;
    public DatabaseConnector databaseConnector;
    public PassengerDataHandler passengerDataHandler;
    public TicketDataHandler ticketDataHandler;


    public PassengerSessionHandler() {
        bookingSystem = new BookingSystem();
        databaseConnector = new DatabaseConnector();
        passengerDataHandler = new PassengerDataHandler(databaseConnector);
        ticketDataHandler = new TicketDataHandler(databaseConnector);

        passengerDataHandler.fetchPassengersIntoApp(this.bookingSystem.passengerManager);
        ticketDataHandler.fetchTicketsIntoApp(this.bookingSystem);

        this.bookingSystem.ticketManager.addObserver(passengerDataHandler);
        this.bookingSystem.ticketManager.addObserver(ticketDataHandler);
    }

    /**
     * implements the abstract method from parent class
     * @param id the id of the passenger
     * @return returns a boolean depedning on whether a passenger with this ID exists
     */
    @Override
    public boolean setSessionUserWithId(int id) {

        this.passenger = this.bookingSystem.passengerManager.getPassengerWithId(id);
        return true;
    }
}
