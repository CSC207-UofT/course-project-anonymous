package interfaceAdapter.presenters;

import Entites.Flight;
import UseCases.factories.SeatFactory;

import java.util.ArrayList;

public class FlightsPresenter {

    public String presentFlight(Flight flight) {
        /*
        Prints out info about a single flight, while search for flight
         */
        String border = "*******************************************************************************************\n";

        String flightName = flight.getAirline().name + "-" + flight.getId() + "\n";

        String fromTo = "From: " + flight.getFrom() + "       To: " + flight.getTo() + "\n";

        String departureLanding = "Departure Date & Time: " + flight.getDepartureTime().toString()
                + "    Landing Date & Time: " + flight.getLandingTime().toString() + "\n";

        String prices = "Economy: " + SeatFactory.economyClassSeatPrice +
                "$   Business: " + SeatFactory.businessClassSeatPrice +
                "$   First: " + SeatFactory.firstClassSeatPrice + "$" ;

        String spacer = "\n";

        return border +
                flightName + spacer +
                fromTo + spacer +
                departureLanding + spacer +
                prices + spacer +
                border + spacer;
    }

    public String presentFlights(ArrayList<Flight> flights) {
        /*
        Uses presentFlight and prints out all the flights
         */
        String stringSoFar = "";

        for (Flight f: flights) {
            stringSoFar += this.presentFlight(f);
        }

        return stringSoFar;
    }
}
