package interfaceAdapter;

import Entites.Airline;
import UseCases.managers.AirlinesManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomFlightsGenerator {

    private AirlinesManager airlinesManager;
    private String starting_date;
    private DateTimeFormatter formatter;

    /**
     *
     * @param airlinesManager airlinesManager takes the name of an airline and returns if it is in the arraylist
     * @param starting_date the starting date for the random flights it wants
     */
    public RandomFlightsGenerator(AirlinesManager airlinesManager, String starting_date) {
        this.airlinesManager = airlinesManager;
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.starting_date = starting_date;
    }

    /**
     * generates pre-created airlines to store in airlinesManager
     */
    public void generateAirlines() {

        String[] airlines = {"Emirates", "Air India", "Air Canada", "Swiss", "United"};

        for (String airline : airlines) {
            this.airlinesManager.addAirline(airline);
        }
    }

    /**
     *  generates a flight route based on input locations
     * @return a flight path based on locations
     */
    public ArrayList<Map<String, String>> generateRoutes() {
        String[] locations = {"London", "LA", "Toronto", "Delhi",
                "Vancouver", "Chicago", "Wisconsin", "Britain", "Sidney"};

        ArrayList<Map<String, String>> routes = new ArrayList<>();

        for (String loc1 : locations) {
            for (String loc2 : locations) {
                if (!loc1.equals(loc2)) {
                    HashMap<String, String> route = new HashMap<>();
                    route.put("from", loc1); route.put("to", loc2);
                    routes.add(route);
                }
            }
        }

        return routes;
    }

    /**
     * generates datetimes based on input starting_date
     * @return an ArrayList of possible date times
     */
    public ArrayList<LocalDateTime> generateDates() {
        String[] starting_dateTimes = {starting_date + " 08:30", starting_date + " 10:00"};

        ArrayList<LocalDateTime> dateTimes = new ArrayList<>();

        for (String starting_dateTime : starting_dateTimes) {
            for (int i = 0; i <= 90; i++) {
                LocalDateTime dateTime = LocalDateTime.parse(starting_dateTime, formatter).plusDays(i);
                dateTimes.add(dateTime);
            }
        }
        return dateTimes;
    }

    /**
     * generates data of miles based on routes and dates
     */
    public void generateData() {
        ArrayList<Map<String, String>> routes = this.generateRoutes();
        ArrayList<LocalDateTime> dateTimes = this.generateDates();

        int miles = 2000;

        for (Airline airline : this.airlinesManager) {
            for (Map<String, String> route : routes) {
                miles += 10;
                for (LocalDateTime departureTime: dateTimes) {
                    airline.addFlight(departureTime, departureTime.plusHours(3), route.get("from"), route.get("to"), miles);
                }
            }
        }
    }

    public void init() {
        this.generateAirlines();
        this.generateData();
    }
}
