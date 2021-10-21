// TODO:  maybe make this an interface and combine BaggageAllowance and Refundable to it
// This is because if we set to to an abs.class then we have to implement interfaces to it, which feels redundant.
public abstract class Seat implements BaggageAllowance{

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

    @Override
    public int numberOfCabinBagsAllowed() {
        return 0;
    }

    @Override
    public int numberOfCheckInBagsAllowed() {
        return 0;
    }

    public String getSeatClass() {
        /*
        Return the class of the seat.

        TODO: this function maybe should not be in this class, as it should only store data.
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