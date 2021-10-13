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
     * id is the id of the plane
     * miles is the no. of miles the plane will travel
     * to is the destination of the plane
     * from is the origin of the plane
     * departureTime is the time of departure of the plane
     * landingTime is the time of arrival of the plane
     * airline is the Airline with which this flight is associated
     * seats is the list of seats on the plane , they are in the order (1,2,3,4,5......360)
     */


    static int firstClassSeats = 20;
    static int businessClassSeats = 90;
    static int economyClassSeats = 250;

    static int firstClassSeatPrice = 200;
    static int businessClassSeatPrice = 150;
    static int economyClassSeatPrice = 100;

    private int id;
    private double miles;
    String to; String from;
    LocalDateTime departureTime; LocalDateTime landingTime;

    Airline airline;
    ArrayList<Seat> seats;

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

        this.seats = new ArrayList<Seat>();
        createSeatMap(Flight.economyClassSeats,
                Flight.businessClassSeats,
                Flight.firstClassSeats);
    }

    private void createSeatMap(int noOfEconomySeats, int noOfBusinessSeats, int noOfFirstSeats) {
        for (int i = 0; i < noOfBusinessSeats + noOfEconomySeats + noOfFirstSeats; i++) {
            if (i < noOfEconomySeats) {
                this.seats.add(new EconomySeat(i, economyClassSeatPrice));
            } else if (i < noOfEconomySeats + noOfBusinessSeats) {
                this.seats.add(new BusinessClassSeat(i, businessClassSeatPrice));
            } else {
                this.seats.add(new FirstClassSeat(i, firstClassSeatPrice));
            }
        }
    }

    // GETTERS AND SETTERS:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
}
