package Entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import UseCases.factories.*;
import UseCases.GeneralIterator;

public class Flight implements Iterable<Seat> {

    public static int firstClassSeats = 18;
    public static int businessClassSeats = 90;
    public static int economyClassSeats = 252;

    private int id;
    private double miles;
    private String to; private String from;
    private LocalDateTime departureTime; private LocalDateTime landingTime;

    private Airline airline;
    private ArrayList<Seat> seats;

    private SeatFactory seatFactory;

    /**
     * Creates a flight with the given departure time, landingTime, origin, destination, mile count,
     * and airline.
     * @param departureTime time for the flight to leave
     * @param landingTime time for the flight to arrive
     * @param from where the flight is originating from
     * @param to where is the flights destination
     * @param miles how many miles was the flight
     * @param flightAirline which airline is the flight
     */
    public Flight(LocalDateTime departureTime,
                  LocalDateTime landingTime,
                  String from, String to,
                  double miles,
                  Airline flightAirline) {
        this.id = -1;
        this.miles = miles;
        this.to = to; this.from = from;
        this.departureTime = departureTime; this.landingTime = landingTime;

        this.airline = flightAirline;
        this.seatFactory = new SeatFactory();

        this.seats = new ArrayList<>();

        createSeatMap(Flight.economyClassSeats,
                      Flight.businessClassSeats,
                      Flight.firstClassSeats);
    }

    /**
     *
     * @param noOfEconomySeats number of economy seats
     * @param noOfBusinessSeats number of business seats
     * @param noOfFirstSeats number of first class seats
     */
    private void createSeatMap(int noOfEconomySeats, int noOfBusinessSeats, int noOfFirstSeats) {
        /*
        Fills in the this.seats list by putting in Seat instances acc. to the numbers given as params
         */
        this.seats = this.seatFactory.createSeatMap(noOfEconomySeats, noOfBusinessSeats, noOfFirstSeats);
    }

    /**
     *
     * @param classNameIndex
     * @return Returns List of Seats according to their type (Economy ("1"), Business ("2"), or First("3"))
     */
    public ArrayList<Seat> getSeatsOfClass(String classNameIndex) {
        /*
        Returns List of Seats according to their type (Economy ("1"), Business ("2"), or First("3"))
        To see how the slices are selected for different type of seat, see this.createSeatMap function.
         */
        return this.seatFactory.getSeatsOfClass(this.seats, classNameIndex);
    }

    // GETTERS AND SETTERS:

    /**
     *
     * @return id of the flight
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id takes an id value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return returns the miles
     */
    public double getMiles() {
        return miles;
    }

    /**
     *
     * @param miles takes number of miles to set
     */
    public void setMiles(double miles) {
        this.miles = miles;
    }

    /**
     *
     * @return returns the time of departure
     */
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    /**
     *
     * @param departureTime time of flight to leave
     */
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    /**
     *
     * @return returns the landing time of the flight
     */
    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    /**
     *
     * @param landingTime takes the landing time of the flight
     */
    public void setLandingTime(LocalDateTime landingTime) {
        this.landingTime = landingTime;
    }

    /**
     *
     * @return returns the destination
     */
    public String getTo() {
        return to;
    }

    /**
     *
     * @return returns the starting point
     */
    public String getFrom() {
        return from;
    }

    /**
     *
     * @return returns the airline name of the flight
     */
    public Airline getAirline() {
        return airline;
    }

    /**
     *
     * @param seat takes a seat object in
     * @return returns the number of the seat
     */
    public int getSeatNo(Seat seat) {return this.seats.indexOf(seat);}

    /**
     *
     * @param index takes the seat number
     * @return returns the corresponding seat object
     */
    public Seat getSeatAtIndex(int index) {return this.seats.get(index);}

    public String getName() {
        return this.getAirline().name + "-" + this.getId();
    }

    @Override
    public Iterator<Seat> iterator() {
        return new GeneralIterator<Seat>(this.seats);
    }
}