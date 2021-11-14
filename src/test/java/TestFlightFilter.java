import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestFlightFilter {
    FlightFilter flightFilter;
    private LocalDateTime date1 = LocalDateTime.of(2020, 05, 10, 19, 30);
    private LocalDateTime date2 = LocalDateTime.of(2020, 05, 10, 21, 30);
    private LocalDateTime date3 = LocalDateTime.of(2020, 05, 1, 14, 30);
    private LocalDateTime date4 = LocalDateTime.of(2020, 05, 10, 18, 30);
    private LocalDate date5 = LocalDate.of(2020, 05, 10);
    @Before
    public void initializeManager() {
        flightFilter = new FlightFilter();

    }

    @Test
    public void testGetFlightFromAirline(){
        Airline airline = new Airline("Air India");
        airline.addFlight(date1, date2, "Delhi", "Toronto", 10);
        airline.addFlight(date3, date4, "Delhi", "Toronto", 10);
        ArrayList<Flight> lst = flightFilter.getFlightFromAirline(airline, "Delhi", "Toronto", date5);
        assert(lst.size()==1);
    }
}
