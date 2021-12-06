package Entites;

import java.time.LocalDateTime;
import java.util.*;

import UseCases.GeneralIterator;

public class Airline implements Iterable<Flight> {
    /**
     * Creates a new airline called string name
     * @param name: the name of the airline
     */

    public String name;
    private int currentFlightId;

    private ArrayList<Flight> flights;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    /**
     * Adds a flight with the given parameters
     * @param departureTime the time of departure
     * @param landingTime the time of landing
     * @param from where the flight departs from
     * @param to where the flight is going
     * @param miles the distance of the flight in miles
     */

    public void addFlight(LocalDateTime departureTime,
                          LocalDateTime landingTime,
                          String from, String to,
                          double miles) {
        Flight flight = new Flight(departureTime, landingTime, from, to, miles, this);

        flight.setId(this.currentFlightId);
        this.currentFlightId++;

        this.flights.add(flight);
    }

    /**
     * Removes a flight matching the input id
     * @param id the id of the flight
     * @return returns if the flight was removed
     */


    public boolean removeFlight(int id) {
        int index = getIndex(id);
        if (index == -1) {return false;}
        this.flights.remove(index);
        return true;
    }

    /**
     * returns the flight based on the index
     * @param id id of the flight
     * @return returns the flight matching the id
     */

    public Flight getFlight(int id) {
        int index = getIndex(id);
        if (index == -1) {return null;}
        return this.flights.get(index);
    }

    /**
     * gets the index of the wanted flight id
     * @param id id of the flight
     * @return returns the index of the flight
     */

    private int getIndex(int id) {
        int index = -1;

        for (int i = 0; i < this.flights.size(); i++) {
            if (this.flights.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Get a flight iterator
     * @return returns a flight iterator
     */
    @Override
    public Iterator<Flight> iterator() {
        return new GeneralIterator<Flight>(this.flights);
    }
}