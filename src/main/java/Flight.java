import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Flight implements Iterable<Seat> {
    static int firstClassSeats = 18;
    static int businessClassSeats = 90;
    static int economyClassSeats = 252;

    private int id;
    private double miles;
    private String to; private String from;
    private LocalDateTime departureTime; private LocalDateTime landingTime;

    private Airline airline;
    private ArrayList<Seat> seats;

    private SeatFactory seatFactory;

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

    private void createSeatMap(int noOfEconomySeats, int noOfBusinessSeats, int noOfFirstSeats) {
        /*
        Fills in the this.seats list by putting in Seat instances acc. to the numbers given as params
         */
        this.seats = this.seatFactory.createSeatMap(noOfEconomySeats, noOfBusinessSeats, noOfFirstSeats);
    }

    public ArrayList<Seat> getSeatsOfClass(String classNameIndex) {
        /*
        Returns List of Seats according to their type (Economy ("1"), Business ("2"), or First("3"))
        To see how the slices are selected for different type of seat, see this.createSeatMap function.
         */
        return this.seatFactory.getSeatsOfClass(this.seats, classNameIndex);
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

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(LocalDateTime landingTime) {
        this.landingTime = landingTime;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Airline getAirline() {
        return airline;
    }

    public int getSeatNo(Seat seat) {return this.seats.indexOf(seat);}

    public Seat getSeatAtIndex(int index) {return this.seats.get(index);}

    @Override
    public Iterator<Seat> iterator() {
        return new GeneralIterator<Seat>(this.seats);
    }
}