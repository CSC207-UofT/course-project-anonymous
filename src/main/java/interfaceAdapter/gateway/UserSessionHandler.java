package interfaceAdapter.gateway;

import Entites.User;
import interfaceAdapter.controller.BookingSystem;

public abstract class UserSessionHandler {
    /**
     * Abstract class to keep track of user that is currently using our app
     */
    private BookingSystem bookingSystem;
    private User user;

    public abstract boolean setSessionUserWithId(int id);
}
