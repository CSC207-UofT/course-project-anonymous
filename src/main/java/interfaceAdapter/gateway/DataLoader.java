package interfaceAdapter.gateway;

import DataConnectors.DataPullPusher;

import UseCases.factories.BaggageFactory;
import interfaceAdapter.controller.BookingSystem;

import java.util.ArrayList;
import java.util.Map;

public class DataLoader {

    DataPullPusher passengerDataPullPusher;
    DataPullPusher ticketDataPullPusher;

    DataLoader(DataPullPusher passengerDataPullPusher, DataPullPusher ticketDataPullPusher) {
        this.passengerDataPullPusher = passengerDataPullPusher;
        this.ticketDataPullPusher = ticketDataPullPusher;
    }

    public void loadData(BookingSystem bookingSystem) {
        this.loadPassengers(bookingSystem);
        this.loadTickets(bookingSystem);
    }

    public void loadPassengers(BookingSystem bookingSystem) {
        ArrayList<Map<String, String>>data = this.passengerDataPullPusher.loadData();

        for (Map<String, String> row : data) {
            bookingSystem.passengerManager.addPassenger(row.get("name"), row.get("email"), row.get("number"),
                    Integer.parseInt(row.get("password")), Integer.parseInt(row.get("points")));
        }
    }

    public void loadTickets(BookingSystem bookingSystem) {
        BaggageFactory baggageFactory = new BaggageFactory();
        ArrayList<Map<String, String>>data = this.ticketDataPullPusher.loadData();

        for (Map<String, String> row : data) {


            bookingSystem.ticketManager.addTicket(

                    bookingSystem.passengerManager.getPassengerWithId(Integer.parseInt(row.get("passengerid"))),

                    bookingSystem.airlinesManager.getFlightByName(row.get("flightname")),

                    bookingSystem.airlinesManager.getFlightByName(row.get("flightname"))
                            .getSeatAtIndex(Integer.parseInt(row.get("seatid"))),

                    bookingSystem.mealsManager.getMeal(row.get("mealname")),

                    baggageFactory.createBaggagesForDataLoading(Integer.parseInt(row.get("cabinbaggages")),
                            Integer.parseInt(row.get("checkinbaggages"))), true);
        }
    }


}
