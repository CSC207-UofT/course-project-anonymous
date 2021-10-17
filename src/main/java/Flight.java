import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {

    // taking the number of seats in a typical plane
    static int firstClassSeats = 18;
    static int businessClassSeats = 90;
    static int economyClassSeats = 252;

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

        this.seats = new ArrayList<>();
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

    public ArrayList<Seat> getSeatsOfClass(String classNameIndex) {

        if (classNameIndex.equals("1")) {
            return new ArrayList<Seat>(this.seats.subList(0, Flight.economyClassSeats));
        } else if (classNameIndex.equals("2")) {
            return new ArrayList<Seat>(this.seats.subList(Flight.economyClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats));
        } else {
            return new ArrayList<Seat>(this.seats.subList(Flight.economyClassSeats + Flight.businessClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats + Flight.firstClassSeats));
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
