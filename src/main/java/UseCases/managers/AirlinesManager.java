package UseCases.managers;

import Entites.Airline;
import Entites.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Entites.Seat;
import UseCases.GeneralIterator;
import UseCases.factories.FlightFactory;
import UseCases.helpers.*;

public class AirlinesManager implements  Iterable<Airline>{
    ArrayList<Airline> airlines;

    public AirlinesManager() {
        this.airlines = new ArrayList<>();
    }

    /**
     * Searches the Arraylist of Airlines for airline called name
     * @param name the airline to retrieve
     * @return the airline if in arraylist, null if not in the list
     */
    public Airline getAirline(String name) {

        int index = getIndex(name);

        if (index == -1) {
            return null;
        }
        return this.airlines.get(index);
    }

    /**
     * Adds an airline to the list
     * @param name  airline to be added
     */
    public void addAirline(String name) {

        this.airlines.add(new Airline(name));
    }

    /**
     * Removes airline from ArrayList
     * @param name  Airline to be removed
     */
    public boolean removeAirline(String name) {

        int index = getIndex(name);

        if (index == -1) {
            return false;
        }
        this.airlines.remove(index);
        return false;
    }

    /**
     * Gets the index of the Airline in the Arraylist
     * @param name  The airline whose index we require
     * @return the index of the airline in the list
     */
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


    public ArrayList<Map<String, String>> getFlightsByFilter(String from, String to, LocalDate date) {
        /**
         * Filters the flights based on the given parameters to return a list of flights
         * that matches the users specification
           @param from starting location of flight
         * @param to destination of flight
         * @param date the date on which we would like to book a flight
         * @return A list of Flight objects
         **/

       FlightFilter flightFilter = new FlightFilter();
       FlightFactory flightFactory = new FlightFactory();

       return flightFactory.getFlightsInfo(flightFilter.getFlightsFromAllAirlines(this, from, to, date));
    }

    public Flight getFlightByName(String name) {
        String[] nameParts = name.split("-");
        return this.getAirline(nameParts[0]).getFlight(Integer.parseInt(nameParts[1]));
    }

    public ArrayList<Seat> getSeatsOfClass(String flightName, String seatClass) {
        Flight flight = this.getFlightByName(flightName);
        return flight.getSeatsOfClass(seatClass);
    }

    public int getSeatIndexByLocalIndex(String flightName, String seatClass, int localIndex) {
        Flight flight = this.getFlightByName(flightName);
        Seat seat = flight.getSeatsOfClass(seatClass).get(localIndex);
        return seat.getId();
    }

    @Override
    public Iterator<Airline> iterator() {
        return new GeneralIterator<Airline>(this.airlines);
    }

    public ArrayList<Airline> getAllAirlines() {
        return this.airlines;
    }
}
