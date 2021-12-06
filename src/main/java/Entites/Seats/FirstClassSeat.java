package Entites.Seats;

public class FirstClassSeat extends Seat {
    /**
     * Construct a FirstClassSeat, giving it the given
     * id and price.
     *
     * @param id The FirstClassSeat's id
     * @param price  The FirstClassSeat's price
     */
    public FirstClassSeat(int id, double price) {
        super(id, price);
    }

    /**
     * @return the number of cabin bags allowed for an FirstClassSeat
     */
    @Override
    public int numberOfCabinBagsAllowed() {
        return 2;
    }

    /**
     * @return the number of check in bags allowed for an FirstClassSeat
     */
    @Override
    public int numberOfCheckInBagsAllowed() {
        return 3;
    }

    /**
     * @return string representation of class name
     */
    @Override
    public String getSeatClass() {
        return "First";
    }
}