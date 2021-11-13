import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class AirlinesManager implements  Iterable<Airline>{
    ArrayList<Airline> airlines;

    public AirlinesManager() {
        this.airlines = new ArrayList<>();
    }

    public Airline getAirline(String name) {
        /**
         * Searches the Arraylist of Airlines for airline called name
         * @param name the airline to retrieve
         * @return the airline if in arraylist, null if not in the list
         */
        int index = getIndex(name);

        if (index == -1) {
            return null;
        }
        return this.airlines.get(index);
    }

    public void addAirline(String name) {
        /**
         * Adds an airline to the list
         * @param name  airline to be added
         */
        this.airlines.add(new Airline(name));
    }

    public boolean removeAirline(String name) {
        /**
         * Removes airline from ArrayList
         * @param name  Airline to be removed
         */
        int index = getIndex(name);

        if (index == -1) {
            return false;
        }
        this.airlines.remove(index);
        return false;
    }

    private int getIndex(String name) {
        /**
         * Gets the index of the Airline in the Arraylist
         * @param name  The airline whose index we require
         * @return the index of the airline in the list
         */
        int index = -1;

        for (int i = 0; i < this.airlines.size(); i++) {
            if (this.airlines.get(i).name.equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public ArrayList<Flight> getFlightsByFilter(String from, String to, LocalDate date) {
        /**
         * Filters the flights based on the given parameters to return a list of flights
         * that matches the users specification
           @param from starting location of flight
         * @param to destination of flight
         * @param date the date on which we would like to book a flight
         * @return A list of Flight objects
         **/
       FlightFilter flightFilter = new FlightFilter();
       return flightFilter.getFlightsFromAllAirlines(this, from, to, date);
    }

    public Flight getFlightByName(String name) {
        String[] nameParts = name.split("-");
        return this.getAirline(nameParts[0]).getFlight(Integer.parseInt(nameParts[1]));
    }

    @Override
    public Iterator<Airline> iterator() {
        return new GeneralIterator<Airline>(this.airlines);
    }
}
