package UseCases.factories;

import Entites.Airline;
import Entites.Flight;
import UseCases.managers.AirlinesManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightFactory {
    public Map<String, String> getFlightInfo(Flight flight) {
        Map<String, String> flightData = new HashMap<>();

        flightData.put("airlineName", flight.getAirline().name);
        flightData.put("flightFrom", flight.getFrom());
        flightData.put("flightTo", flight.getTo());
        flightData.put("flightId",  "" + flight.getId());
        flightData.put("flightDepartureTime", flight.getDepartureTime().toString());
        flightData.put("flightLandingTime", flight.getLandingTime().toString());

        return flightData;
    }

    ArrayList<Map<String, String>> getFlightsInfoForAnAirline(Airline airline) {

        ArrayList<Map<String, String>> flightsData = new ArrayList<>();

        for (Flight flight : airline) {
            flightsData.add(this.getFlightInfo(flight));
        }

        return flightsData;
    }

    public ArrayList<Map<String, String>> getAllFlightsInfo(AirlinesManager airlinesManager) {
        ArrayList<Map<String, String>> flightsData = new ArrayList<>();

        for (Airline airline : airlinesManager) {
            flightsData.addAll(this.getFlightsInfoForAnAirline(airline));
        }

        return flightsData;
    }

    public ArrayList<Map<String, String>> getFlightsInfo(ArrayList<Flight> flights) {
        ArrayList<Map<String, String>> flightsData = new ArrayList<>();

        for (Flight flight : flights) {
            flightsData.add(this.getFlightInfo(flight));
        }

        return flightsData;
    }
}
