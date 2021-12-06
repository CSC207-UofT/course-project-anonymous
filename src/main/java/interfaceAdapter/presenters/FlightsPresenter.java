package interfaceAdapter.presenters;

import UseCases.factories.SeatFactory;
import java.util.ArrayList;
import java.util.Map;

public class FlightsPresenter {

    /**
     * returns all the information about a flight given by the flightData
     *
     * @param flightData a map representing all the flight's data
     *
     * @return string representing the info of a single flight
     **/
    public String presentFlight(Map<String, String> flightData) {
        /*
        Prints out info about a single flight, while search for flight
         */

        String border = "*******************************************************************************************\n";

        String flightName = flightData.get("airlineName") + "-" + flightData.get("flightId")+ "\n";

        String fromTo = "From: " + flightData.get("flightFrom") + "       To: " + flightData.get("flightTo") + "\n";

        String departureLanding = "Departure Date & Time: " + flightData.get("flightDepartureTime")
                + "    Landing Date & Time: " + flightData.get("flightLandingTime") + "\n";

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

    /**
     * returns all the information about all flights in flightsData
     *
     * @param flightsData a list of mappings representing the data of multiple flights
     *
     * @return string representing the info of all given flights in flightsData
     **/
    public String presentFlights(ArrayList<Map<String, String>> flightsData) {
        /*
        Uses presentFlight and prints out all the flights
         */
        String stringSoFar = "";

        for (Map<String, String> flightData: flightsData) {
            stringSoFar += this.presentFlight(flightData);
        }

        return stringSoFar;
    }
}
