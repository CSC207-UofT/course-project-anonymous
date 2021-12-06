package interfaceAdapter.gateway;

import DataConnectors.DataPullPusher;

import UseCases.factories.BaggageFactory;
import interfaceAdapter.controller.BookingSystem;

import java.util.ArrayList;
import java.util.Map;

public class DataLoader {

    DataPullPusher passengerDataPullPusher;
    DataPullPusher ticketDataPullPusher;

    /**
     * Initializes a new Dataloader class
     *
     * @param passengerDataPullPusher a DataPullPusher of type PassengerPullPusher for handling passenger data
     * @param ticketDataPullPusher a DataPullPusher of type TicketPullPusher for handling ticket data
     */
    DataLoader(DataPullPusher passengerDataPullPusher, DataPullPusher ticketDataPullPusher) {
        this.passengerDataPullPusher = passengerDataPullPusher;
        this.ticketDataPullPusher = ticketDataPullPusher;
    }

    /**
     * Load the data for both passengers and tickets by calling helper functions
     * @param bookingSystem the booking system of the app
     */
    public void loadData(BookingSystem bookingSystem) {
        this.loadPassengers(bookingSystem);
        this.loadTickets(bookingSystem);
    }

    /**
     * Use this.passengerDataPullPusher to pull all the data of passangers into the app
     * @param bookingSystem the booking system of the app
     */
    public void loadPassengers(BookingSystem bookingSystem) {
        ArrayList<Map<String, String>>data = this.passengerDataPullPusher.loadData();

        for (Map<String, String> row : data) {
            bookingSystem.passengerManager.addPassenger(row.get("name"), row.get("email"), row.get("number"),
                    Integer.parseInt(row.get("password")), Integer.parseInt(row.get("points")));
        }
    }

    /**
     * Use this.passengerDataPullPusher to pull all the data of tickets into the app
     * @param bookingSystem the booking system of the app
     */
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
