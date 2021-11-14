package interfaceAdapter.gateway;

import Entites.Passenger;
import interfaceAdapter.controller.*;

public class PassengerSessionHandler extends UserSessionHandler {
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

    @Override
    public boolean setSessionUserWithId(int id) {
        this.passenger = this.bookingSystem.passengerManager.getPassengerWithId(id);
        return !this.passenger.equals(null);
    }
}
