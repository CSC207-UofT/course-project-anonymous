import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class AirlinesManager implements  Iterable<Airline>{
    ArrayList<Airline> airlines;

    public AirlinesManager() {
        this.airlines = new ArrayList<>();
    }

    public Airline getAirline(String name) {
        int index = getIndex(name);

        if (index == -1) {
            return null;
        }
        return this.airlines.get(index);
    }

    public void addAirline(String name) {
        this.airlines.add(new Airline(name));
    }

    public boolean removeAirline(String name) {
        int index = getIndex(name);

        if (index == -1) {
            return false;
        }
        this.airlines.remove(index);
        return false;
    }

    private int getIndex(String name) {
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
        /*
        Collect flights with the specific parameters from all the airlines in the manager, and return a combined list.
         */
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
