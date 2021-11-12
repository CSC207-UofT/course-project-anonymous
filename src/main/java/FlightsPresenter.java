import java.util.ArrayList;

public class FlightsPresenter {

    public static String presentFlight(Flight flight) {
        /*
        Prints out info about a single flight, while search for flight

        TODO: make this method non static
         */
        String border = "*******************************************************************************************\n";

        String flightName = flight.airline.name + "-" + flight.getId() + "\n";

        String fromTo = "From: " + flight.from + "       To: " + flight.to + "\n";

        String departureLanding = "Departure Date & Time: " + flight.departureTime.toString()
                + "    Landing Date & Time: " + flight.landingTime.toString() + "\n";

        String prices = "Economy: " + Flight.economyClassSeatPrice +
                "$   Business: " + Flight.businessClassSeatPrice +
                "$   First: " + Flight.firstClassSeatPrice + "$" ;

        String spacer = "\n";

        return border +
                flightName + spacer +
                fromTo + spacer +
                departureLanding + spacer +
                prices + spacer +
                border + spacer;
    }

    public static String presentFlights(ArrayList<Flight> flights) {
        /*
        Uses presentFlight and prints out all the flights

        TODO: make this method non static
         */
        String stringSoFar = "";

        for (Flight f: flights) {
            stringSoFar += FlightsPresenter.presentFlight(f);
        }

        return stringSoFar;
    }

    public static String presentSeats(ArrayList<Seat> seats) {
        /*
        Prints out the seat map for the given seats array

        TODO: should be shifted top seat map presenter
         */

        String starting_string = "  0 1 2 3 4 5 6 7 8\n \n";

        for (int i = 0; i < seats.size(); i+=9) {
            String seatsRowString = "";
            for (int j = i; j < i+9; j++) {
                seatsRowString += seats.get(j).getOccupiedSymbol() + " ";
            }
            starting_string +=  (int) Math.floor(i/9) + " " + seatsRowString + "\n";
        }

        return starting_string;
    }


}
