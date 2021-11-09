public class BusinessClassSeat extends Seat{
    private double price;

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
     * @return the price of this BusinessClassSeat
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of this BusinessClassSeat to the given price
     *
     * @param price     The BusinessClassSeat's price
     */
    public void setPrice(double price) {
        this.price = price;
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
}