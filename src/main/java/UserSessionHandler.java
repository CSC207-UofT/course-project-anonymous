public abstract class UserSessionHandler {
    private BookingSystem bookingSystem;
    private User user;

    public UserSessionHandler() {
        this.bookingSystem = new BookingSystem();
    }
}
