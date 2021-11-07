import java.time.LocalDate;
import java.util.ArrayList;

public class AirlinesManager {
    // TODO: implement iterator design pattern
    ArrayList<Airline> airlines;

    public AirlinesManager() {
        this.airlines = new ArrayList<>();
    }

    public Airline getAirline(String name) {
        int index = -1;

        for (int i = 0; i < this.airlines.size(); i++) {
            if (this.airlines.get(i).name.equals(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }
        return this.airlines.get(index);
    }

    public void addAirline(String name) {
        this.airlines.add(new Airline(name));
    }

    public boolean removeAirline(String name) {
        int index = -1;

        for (int i = 0; i < this.airlines.size(); i++) {
            if (this.airlines.get(i).name == name) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.airlines.remove(index);
        return false;
    }

    // TODO: Maybe airline managers work is not to get filtered flights, so maybe we can use/make another use case to filter and search flights
    // ^ just an idea, maybe this is fine here, i am confused 😭.

    public ArrayList<Flight> getFlightsByFilter(String from, String to, LocalDate date) {
        /*
        Collect flights with the specific parameters from all the airlines in the manager, and return a combined list.

        - it uses Airline.getFlightByFilter function
        - it uses addAll function of arraylist to combine all arraylists.
         */
        ArrayList<Flight> flights = new ArrayList<>();

        for (Airline a: this.airlines) {
            flights.addAll(a.getFlightByFilter(from, to, date));
        }

        return flights;
    }

    public Flight getFlightByName(String name) {
        String[] nameParts = name.split("-");
        return this.getAirline(nameParts[0]).getFlight(Integer.parseInt(nameParts[1]));
    }

}
