package Entites;

public class EconomySeat extends Seat {
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

    /**
    * @return string representation of class name
    */
    @Override
    public String getSeatClass() {
        return "Economy";
    }
}
