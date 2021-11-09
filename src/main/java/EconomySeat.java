public class EconomySeat extends Seat{
    private double price;

    /**
     * Construct an EconomySeat, giving it the given
     * id and price.
     *
     * @param id The EconomySeat's id
     * @param price  The EconomySeat's price
     */
    public EconomySeat(int id, double price) {
        super(id, price);
    }

    /**
     * @return the price of this EconomySeat
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of this EconomySeat to the given price
     *
     * @param price     The EconomySeat's price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the number of cabin bags allowed for an EconomySeat
     */
    @Override
    public int numberOfCabinBagsAllowed() {
        return 1;
    }

    /**
     * @return the number of check in bags allowed for an EconomySeat
     */
    @Override
    public int numberOfCheckInBagsAllowed() {
        return 2;
    }
}
