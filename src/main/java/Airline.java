import java.time.LocalDateTime;
import java.util.ArrayList;

public class Airline {
    String name;
    private ArrayList<Flight> flights;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public void addFlight(LocalDateTime departureTime, LocalDateTime ArrivalTime, String origin, String destination,
                          double miles) {
        Flight flight = new Flight(departureTime, ArrivalTime, origin, destination, miles, this);

        this.flights.add(flight);
    }

    public void removeFlight(int flightno) {

        this.flights.remove(flightno);
    }

    public Flight getFlight(int flightno) {

        return this.flights.get(flightno);
    }
}
