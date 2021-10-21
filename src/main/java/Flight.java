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

        // TODO: implement the iterator design pattern for seats arraylist.
        this.seats = new ArrayList<>();

        createSeatMap(Flight.economyClassSeats,
                      Flight.businessClassSeats,
                      Flight.firstClassSeats);
    }

    private void createSeatMap(int noOfEconomySeats, int noOfBusinessSeats, int noOfFirstSeats) {
        /*
        Fills in the this.seats list by putting in Seat instances acc. to the numbers given as params.

        The function does te following:
        - First append <noOfEconomySeats> number of Economy seats
        - Next append <noOfBusinessSeats> number of Business class seats
        - Finally append <noOfFirstSeats> number of First class seats

        The indexing is as follows:
        - if 0 <= i < noOfEconomySeats, then the seat is Economy
        - if noOfEconomySeats <= i < noOfEconomySeats + noOfBusinessSeats, then the seat is of Business class
        - else if i < noOfEconomySeats + noOfBusinessSeats + noOfFirstSeats. then the seat is of First class

        TODO: decide if this function should remain here or not, because the only function of this class should be to store data.
         */
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
        /*
        Returns List of Seats according to their type (Economy ("1"), Business ("2"), or First("3"))
        To see how the slices are selected for different type of seat, see this.createSeatMap function.

        TODO: this function should not be in this class, this is an entity class and it should only store info.
         */
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
    // TODO: Add get set for departure date and all the other variables

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