package Entites.Memberships.Seats;

public class BusinessClassSeat extends Seat {
    /**
     * Construct a BusinessClassSeat, giving it the given
     * id and price.
     *
     * @param id The BusinessClassSeat's id
     * @param price  The BusinessClassSeat's price
     */
    public BusinessClassSeat(int id, double price) {
        super(id, price);
    }

    /**
     * @return the number of cabin bags allowed for a BusinessClassSeat
     */
    @Override
    public int numberOfCabinBagsAllowed() {
        return 2;
    }

    /**
     * @return the number of check in bags allowed for a BusinessClassSeat
     */
    @Override
    public int numberOfCheckInBagsAllowed() {
        return 2;
    }

    /**
     * @return string representation of class name
     */
    @Override
    public String getSeatClass() {
        return "Business";
    }
}