package interfaceAdapter.gateway;

import Entites.User;
import interfaceAdapter.controller.BookingSystem;

public abstract class UserSessionHandler {
    private BookingSystem bookingSystem;
    private User user;

    public abstract boolean setSessionUserWithId(int id);
}
