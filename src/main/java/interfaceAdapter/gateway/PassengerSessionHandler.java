package interfaceAdapter.gateway;
import DataConnectors.DataPullPusher;
import interfaceAdapter.controller.*;

import java.util.HashMap;
import java.util.Map;

public class PassengerSessionHandler extends UserSessionHandler {
    public int passengerId;
    public Map<String, String> passengerInfo;
    public BookingSystem bookingSystem;

    DataPullPusher passengerDataPullPusher;
    DataPullPusher ticketDataPullPusher;

    DataLoader dataLoader;

    public PassengerSessionHandler(DataPullPusher passengerDataPullPusher, DataPullPusher ticketDataPullPusher) {
        bookingSystem = new BookingSystem();

        this.passengerDataPullPusher = passengerDataPullPusher;
        this.ticketDataPullPusher = ticketDataPullPusher;

        dataLoader = new DataLoader(this.passengerDataPullPusher, this.ticketDataPullPusher);
        dataLoader.loadData(bookingSystem);

        this.bookingSystem.ticketManager.addObserver(this.passengerDataPullPusher);
        this.bookingSystem.ticketManager.addObserver(this.ticketDataPullPusher);
    }

    @Override
    public boolean setSessionUserWithId(int id) {
        this.passengerId = id;
        this.passengerInfo = this.bookingSystem.passengerManager.getPassengerInfoById(id);
        return !this.passengerInfo.equals(null);
    }

    public void updatePassengerInfo() {
        this.passengerInfo = this.bookingSystem.passengerManager.getPassengerInfoById(this.passengerId);
    }

    public int sign_up(String name, String email, String number) {
        int id = this.bookingSystem.passengerManager.addPassenger(name, email, number);
        Map<String, String> passengerData = new HashMap<>();
        passengerData.put("name", name);
        passengerData.put("email", email);
        passengerData.put("number", number);
        passengerData.put("id", id + "");

        this.passengerDataPullPusher.addEntity(passengerData);
        return id;
    }

    public void removeTicket(Map<String, String> ticketInfo) {
        this.ticketDataPullPusher.removeEntity(ticketInfo);
        this.bookingSystem.ticketManager.removeTicket(this.bookingSystem.ticketManager.getTicketFromInfo(ticketInfo));
    }
}
