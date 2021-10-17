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
        if (this instanceof EconomySeat) {
            return "Economy";
        } else if (this instanceof BusinessClassSeat) {
            return "Business";
        } else {
            return "First";
        }
    }
}
