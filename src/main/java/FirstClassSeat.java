public class FirstClassSeat extends Seat{
    private double price;

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
     * @return the price of this FirstClassSeat
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of this FirstClassSeat to the given price
     *
     * @param price     The FirstClassSeat's price
     */
    public void setPrice(double price) {
        this.price = price;
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
}