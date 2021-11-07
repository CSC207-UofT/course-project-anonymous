public class PassengerSessionHandler extends UserSessionHandler {
    Passenger passenger;
    BookingSystem bookingSystem;

    public PassengerSessionHandler() {
        bookingSystem = new BookingSystem();
    }

    @Override
    public boolean setSessionUserWithId(int id) {
        this.passenger = this.bookingSystem.passengerManager.getPassengerWithId(id);
        return !this.passenger.equals(null);
    }
}
