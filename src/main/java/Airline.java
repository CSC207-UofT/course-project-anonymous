import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Airline {
    String name;
    private int currentFlightId;
    private ArrayList<Flight> flights;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public void addFlight(LocalDateTime departureTime,
                          LocalDateTime landingTime,
                          String from, String to,
                          double miles) {
        Flight flight = new Flight(departureTime, landingTime, from, to, miles, this);

        flight.setId(this.currentFlightId);
        this.currentFlightId++;

        this.flights.add(flight);
    }

    public boolean removeFlight(int id) {
        int index = -1;

        for (int i = 0; i < this.flights.size(); i++) {
            if (this.flights.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.flights.remove(index);
        return true;
    }

    public Flight getFlight(int id) {
        int index = -1;

        for (int i = 0; i < this.flights.size(); i++) {
            if (this.flights.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        return this.flights.get(index);
    }

    public ArrayList<Flight> getFlightByFilter(String from, String to, LocalDate date) {
        ArrayList<Integer> indices = new ArrayList<>();
        ArrayList<Flight> flightsOnDate = new ArrayList<>();

        for (int i = 0; i < this.flights.size(); i++) {
            if (this.flights.get(i).departureTime.toLocalDate().equals(date)) {
                if (this.flights.get(i).from == from && this.flights.get(i).to == to) {
                    indices.add(i);
                }
            }
        }

        for (int index : indices) {
            flightsOnDate.add(this.flights.get(index));
        }

        return flightsOnDate;
    }
}
