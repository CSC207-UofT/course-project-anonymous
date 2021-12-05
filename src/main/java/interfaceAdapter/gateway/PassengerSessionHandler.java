package interfaceAdapter.gateway;
import interfaceAdapter.controller.*;
import java.util.Map;

public class PassengerSessionHandler extends UserSessionHandler {
    public int passengerId;
    public Map<String, String> passengerInfo;
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
        this.passengerInfo = this.bookingSystem.passengerManager.getPassengerInfoById(id);
        return !this.passengerInfo.equals(null);
    }

    public int sign_up(String name, String email, String number) {
        int id = this.bookingSystem.passengerManager.addPassenger(name, email, number);
        this.passengerDataHandler.addPassenger(name, email, number, id + "");
        return id;
    }

    public void removeTicket(Map<String, String> ticketInfo) {
        this.bookingSystem.ticketManager.removeTicket(this.bookingSystem.ticketManager.getTicketFromInfo(ticketInfo));
        this.ticketDataHandler.removeTicket(this.bookingSystem.ticketManager.getTicketFromInfo(ticketInfo));
    }
}
