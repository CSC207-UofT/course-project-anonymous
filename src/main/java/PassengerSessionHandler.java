public class PassengerSessionHandler extends UserSessionHandler {
    Passenger passenger;
    BookingSystem bookingSystem;
    DatabaseConnector databaseConnector;
    PassengerDataHandler passengerDataHandler;

    public PassengerSessionHandler() {
        bookingSystem = new BookingSystem();
        databaseConnector = new DatabaseConnector();
        passengerDataHandler = new PassengerDataHandler(databaseConnector);
        passengerDataHandler.fetchPassengersIntoApp(this.bookingSystem.passengerManager);
        this.bookingSystem.ticketManager.addObserver(passengerDataHandler);
    }

    @Override
    public boolean setSessionUserWithId(int id) {
        this.passenger = this.bookingSystem.passengerManager.getPassengerWithId(id);
        return !this.passenger.equals(null);
    }
}
