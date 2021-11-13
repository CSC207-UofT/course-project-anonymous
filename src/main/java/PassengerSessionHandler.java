public class PassengerSessionHandler extends UserSessionHandler {
    Passenger passenger;
    BookingSystem bookingSystem;
    DatabaseConnector databaseConnector;
    PassengerDataHandler passengerDataHandler;
    TicketDataHandler ticketDataHandler;

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
