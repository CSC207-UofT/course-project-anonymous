package UseCases.factories;

import Entites.*;
import Entites.Seats.BusinessClassSeat;
import Entites.Seats.EconomySeat;
import Entites.Seats.FirstClassSeat;
import Entites.Seats.Seat;

import java.util.ArrayList;

public class SeatFactory {

    public static double firstClassSeatPrice = 200;
    public static double businessClassSeatPrice = 150;
    public static double economyClassSeatPrice = 100;

    /**
     * return the desired object of type Seat
     *
     * @param seatType the type of Seat
     * @param id       the seat's id
     * @param price    the seat's price
     * @return the object of the corresponding type MembershipStatus
     **/
    public Seat getSeat(String seatType, int id, double price) {
        if (seatType == null) {
            return null;
        }
        if (seatType.equalsIgnoreCase("ECONOMYSEAT")) {
            return new EconomySeat(id, price);

        } else if (seatType.equalsIgnoreCase("FIRSTCLASSSEAT")) {
            return new FirstClassSeat(id, price);

        } else if (seatType.equalsIgnoreCase("BUSINESSCLASSSEAT")) {
            return new BusinessClassSeat(id, price);
        }
        return null;
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
     * where Economy represents the classNameIndex "1", Business represents "2",
     * and First represents "3".
     * To see how the slices are selected for different type of seat,
     * see this.createSeatMap function.
     *
     * @param seats a list of seats
     * @param classNameIndex the index corresponding to a certain type of seat
     *
     * @return the list of seats according to their type
     */
    public ArrayList<Seat> getSeatsOfClass(ArrayList<Seat> seats, String classNameIndex) {
        if (classNameIndex.equals("1")) {
            return new ArrayList<>(seats.subList(0, Flight.economyClassSeats));
        } else if (classNameIndex.equals("2")) {
            return new ArrayList<>(seats.subList(Flight.economyClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats));
        } else {
            return new ArrayList<>(seats.subList(Flight.economyClassSeats + Flight.businessClassSeats,
                    Flight.economyClassSeats + Flight.businessClassSeats + Flight.firstClassSeats));
        }
    }

    /**
     * Maps list of seats to a boolean value indicating if they are occupied
     *
     * @param seats Arraylist of seats
     *
     * @return Arraylist of boolean values indicating if they are occupied
     */
    public ArrayList<Boolean> getSeatSymbols(ArrayList<Seat> seats) {
        ArrayList<Boolean> symbols = new ArrayList<>();
        for (Seat seat : seats) {symbols.add(seat.getOccupied());}
        return symbols;
    }
}
