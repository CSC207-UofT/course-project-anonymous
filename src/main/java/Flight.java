import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {
    /**
     * firstClassSeats represent the no. of First Class Seats in our flight
     * businessClassSeats represent the no. of Business Class Seats in our flight
     * economyClassSeats represent the no. of Economy Class Seats in our flight
     * firstClassSeatPrice represents the price of a First Class Seat in our flight
     * businessClassSeatPrice represents the price of a Business Class Seat in our flight
     * economyClassSeatPrice represents the price of an Economy Class Seat in our flight
     * miles is the no. of miles the plane will travel
     * destination is the destination of the plane
     * origin is the origin of the plane
     * departureTime is the time of departure of the plane
     * arrivalTime is the time of arrival of the plane
     * airline is the Airline with which this flight is associated
     * seats is the list of seats on the plane , they are in the order (1,2,3,4,5......360)
     */


    static int firstClassSeats = 20;
    static int businessClassSeats = 90;
    static int economyClassSeats = 250;
    static int capacity = 360;

    static int firstClassSeatPrice = 200;
    static int businessClassSeatPrice = 150;
    static int economyClassSeatPrice = 100;

    private double miles;
    String destination;
    String origin;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;

    Airline airline;
    ArrayList<Seat> seats;

    public Flight(LocalDateTime departureTime, LocalDateTime arrivalTime, String destination, String origin,
                  double miles,
                  Airline flightAirline) {
        this.miles = miles;
        this.destination = destination;
        this.origin = origin;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

        this.airline = flightAirline;

        this.seats = new ArrayList<Seat>();

    }


    // GETTERS AND SETTERS:


    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setMiles(double miles){
        this.miles = miles;
    }

    public double getMiles(){
        return miles;
    }




}
