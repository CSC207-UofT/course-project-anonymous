import java.util.ArrayList;

public class SeatManager {
    static int firstClassSeatPrice = 200;
    static int businessClassSeatPrice = 150;
    static int economyClassSeatPrice = 100;
    Seat seat;

    /**
     * Construct a SeatManager, giving it the given
     * seat object
     *
     * @param seat A seat object
     */
    public SeatManager(Seat seat) {
        this.seat = seat;
    }

    /**
     * Calculate the refund price for a given Seat based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     * @param departureDate the departure date of the flight
     *
     * @return the refunded price of the Seat
     */
    public double calculateRefundByDaysLeft(int daysLeft, int departureDate) {
        // full refund if refund asked before 7 days of the flight
        if (daysLeft >= 7) {
            return this.seat.getPrice();
        } else if (daysLeft >= 1) {
            // partial refund is provided if refund is asked before 1 day of the flight
            // and the refund decreases as you get closer to departure date
            return this.seat.getPrice() -
                    (this.seat.getPrice() * (departureDate - daysLeft) * 0.01);
        } else {
            // no refund is provided if asked for refund the day of the flight
            return 0;
        }
    }

    /**
     * Calculate the charge for changing the date of departure based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     * @param departureDate the departure date of the flight
     *
     * @return the charge price of making this change
     */
    public double calculateDateChangeChargeByDateLeft(int daysLeft, int departureDate) {
        // no charge if date is changed a week before departure date
        if (daysLeft >= 7) {
            return 0;
        } else {
            // charge increases as you get closer to departure date
            return (this.seat.getPrice() * (departureDate - daysLeft) * 0.01);
        }
    }

    /**
     * Creates a seat list in order of economy, business, first by putting in
     * Seat instances according to the numbers given as paramaters.
     *
     * @param noOfEconomySeats the number of economy class seats
     * @param noOfBusinessSeats the number of business class seats
     * @param noOfFirstSeats the number of first class seats
     *
     * @return array list of seats
     *
     * The function does te following:
     * - First append <noOfEconomySeats> number of Economy seats
     * - Next append <noOfBusinessSeats> number of Business class seats
     * - Finally append <noOfFirstSeats> number of First class seats
     *
     * The indexing is as follows:
     * - if 0 <= i < noOfEconomySeats, then the seat is Economy
     * - if noOfEconomySeats <= i < noOfEconomySeats + noOfBusinessSeats, then the seat is of Business class
     * - else if i < noOfEconomySeats + noOfBusinessSeats + noOfFirstSeats. then the seat is of First class
     */
    public ArrayList<Seat> createSeatMap(int noOfEconomySeats, int noOfBusinessSeats, int noOfFirstSeats) {
        ArrayList<Seat> seats = new ArrayList<>();

        for (int i = 0; i < noOfBusinessSeats + noOfEconomySeats + noOfFirstSeats; i++) {
            if (i < noOfEconomySeats) {
                seats.add(new EconomySeat(i, economyClassSeatPrice));
            } else if (i < noOfEconomySeats + noOfBusinessSeats) {
                seats.add(new BusinessClassSeat(i, businessClassSeatPrice));
            } else {
                seats.add(new FirstClassSeat(i, firstClassSeatPrice));
            }
        }

        return seats;
    }

    /**
     * Returns List of Seats according to their type
     * where Economy represents the classNameIndex "1", Business represents "2"),
     * and First represents "3".
     * To see how the slices are selected for different type of seat,
     * see this.createSeatMap function.
     *
     * @param seats how many days are left until the departure date
     * @param classNameIndex the index corresponding to a certain type of seat
     *
     * @return the list of seats according to their type
     */
    public ArrayList<Seat> getSeatsOfClass(ArrayList<Seat> seats, String classNameIndex) {
        if (classNameIndex.equals("1")) {
            return new ArrayList<Seat>(seats.subList(0, Flight.economyClassSeats));
        } else if (classNameIndex.equals("2")) {
            return new ArrayList<Seat>(seats.subList(Flight.economyClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats));
        } else {
            return new ArrayList<Seat>(seats.subList(Flight.economyClassSeats + Flight.businessClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats + Flight.firstClassSeats));
        }
    }
}
