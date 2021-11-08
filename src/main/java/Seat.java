public abstract class Seat{

    private int id;
    private double price;
    private boolean isOccupied;

    public Seat(int id) {
        this.id = id;
        this.isOccupied = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getOccupiedSymbol() {
        /*
        Return the symbol of if it is ocupied or not

        TODO: this function maybe should not be in this class, as it already stores data on isOccupied.
         */
        if (this.isOccupied) {
            return "x";
        } else {
            return "o";
        }
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract int numberOfCabinBagsAllowed();

    public abstract int numberOfCheckInBagsAllowed();

    public abstract double calculateRefundByDaysLeft(double price, int daysLeft);

    public abstract double calculateDateChangeChargeByDateLeft(double price, int daysLeft);

    public String getSeatClass() {
        /*
        Return the class of the seat.
         */
        if (this instanceof EconomySeat) {
            return "Economy";
        } else if (this instanceof BusinessClassSeat) {
            return "Business";
        } else {
            return "First";
        }
    }
}