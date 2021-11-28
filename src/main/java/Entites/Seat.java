package Entites;

public abstract class Seat {
    private int id;
    private double price;
    private boolean isOccupied;

    /**
     * Construct a Seat, giving it the given
     * id and price. The occupied status of a Seat
     * is set to false by default
     *
     * @param id The EconomySeat's id
     * @param price  The EconomySeat's price
     */
    public Seat(int id, double price) {
        this.id = id;
        this.isOccupied = false;
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

    /**
     * @return the occupied status of this Seat
     */
    public boolean getOccupied() {
        return this.isOccupied;
    }

    /**
     * Set the occupied status of this Seat
     * to the given occupied status
     *
     * @param isOccupied     The Seat's occupied status
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * @return the symbol of if this seat is occupied or not
     */
    public String getOccupiedSymbol() {
        if (this.isOccupied) {
            return "x";
        } else {
            return "o";
        }
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
     * @return which class the Seat represents
     */
    public abstract String getSeatClass();
}