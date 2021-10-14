import java.util.ArrayList;

public class FlightsPresenter {

    public static String presentFlight(Flight flight) {
        String border = "************************************************\n";

        String flightName = flight.airline.name + "-" + flight.getId() + "\n";

        String fromTo = "   From: " + flight.from + "       To: " + flight.to + "\n";

        String departureLanding = "   Departure Date & Time: " + flight.departureTime.toString()
                + "       Landing Date & Time: " + flight.landingTime.toString();

        String prices = "Economy: " + Flight.economyClassSeatPrice +
                "   Business: " + Flight.businessClassSeatPrice +
                "   First: " + Flight.firstClassSeatPrice ;

        String spacer = "\n";

        return border + spacer +
                flightName + spacer +
                fromTo + spacer +
                departureLanding + spacer +
                prices + spacer +
                border + spacer;
    }

    public static String presentFlights(ArrayList<Flight> flights) {
        String stringSoFar = "";

        for (Flight f: flights) {
            stringSoFar += FlightsPresenter.presentFlight(f);
        }

        return stringSoFar;
    }
}
