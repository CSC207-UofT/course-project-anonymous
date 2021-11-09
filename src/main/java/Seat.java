public abstract class Seat{
    private int id;
    private double price;
    // private boolean isOccupied;
    // isOccupied takes values of "x" meaning occupied or "o" meaning available
    private String isOccupied;

    /**
     * Construct a Seat, giving it the given
     * id and price.
     *
     * @param id The EconomySeat's id
     * @param price  The EconomySeat's price
     */
    public Seat(int id, double price) {
        this.id = id;
        this.isOccupied = "o"; // "o" meaning available
        this.price = price;
    }

    /**
     * @return the id of this Seat
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of this Seat to the given id
     *
     * @param id     The Seat's id
     */
    public void setId(int id) {
        this.id = id;
    }

//    public boolean isOccupied() {
//        return isOccupied;
//    }

    /**
     * @return whether this seat is occupied or not
     */
    public String getOccupiedSymbol() {
        /*
        Return the symbol of if it is ocupied or not
         */
//        if (this.isOccupied) {
//            return "x";
//        } else {
//            return "o";
//        }
        return this.isOccupied;
    }

    /**
     * Set the occupied status of this Seat
     * to the given occupied status
     *
     * @param occupied     The Seat's occupied status
     */
    public void setOccupiedSymbol(String occupied) {
        this.isOccupied = occupied;
    }

    /**
     * @return the Seat's price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Set the price of this Seat to the given price
     *
     * @param price     The Seat's price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Abstract function
     *
     * @return the number of cabin bags allowed for a Seat
     */
    public abstract int numberOfCabinBagsAllowed();

    /**
     * Abstract function
     *
     * @return the number of check in bags allowed for a Seat
     */
    public abstract int numberOfCheckInBagsAllowed();

    /**
     * Calculate the refund price for a given Seat based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     *
     * @return the refunded price of the Seat
     */
    public double calculateRefundByDaysLeft(int daysLeft) {
        // full refund if refund asked before 7 days of the flight
        if (daysLeft >= 7) {
            return 0;
        } else if (daysLeft >= 1) {
            // partial refund if asked before 1 day but
            // after 7 days of the flight
            return this.price - (this.price * daysLeft * 0.01);
        } else {
            return this.price;
        }
    }

    /**
     * Calculate the charge for changing the date of departure based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     *
     * @return the charge price of making this change
     */
    //TODO implement this function
    public double calculateDateChangeChargeByDateLeft(int daysLeft) {
        return 0;
    }

    /**
     * @return which class the Seat represents
     */
    public String getSeatClass() {
        //TODO maybe shift this to a use case?
        //maybe better to keep it here since we won't have to define it in every use case class
        // we use it in
        if (this instanceof EconomySeat) {
            return "Economy";
        } else if (this instanceof BusinessClassSeat) {
            return "Business";
        } else {
            return "First";
        }
    }
}