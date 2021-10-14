public class PassengerSessionHandler extends UserSessionHandler {
    private Passenger passenger;
    BookingSystem bookingSystem;

    public PassengerSessionHandler() {
        bookingSystem = new BookingSystem();
    }

    public boolean setSessionPassengerWithId(int id) {
        this.passenger = this.bookingSystem.passengerManager.getPassengerWithId(id);
        return !this.passenger.equals(null);
    }
}
