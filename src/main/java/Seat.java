public abstract class Seat{

    private int id;
    private double price;
//    private boolean isOccupied;
    // isOccupied takes values of "x" meaning occupied or "o" meaning available
    private String isOccupied;

    public Seat(int id, String isOccupied) {
        this.id = id;
        this.isOccupied = isOccupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public boolean isOccupied() {
//        return isOccupied;
//    }

    public String getOccupiedSymbol() {
        /*
        Return the symbol of if it is ocupied or not
         */
//        if (this.isOccupied) {
//            return "x";
//        } else {
//            return "o";
//        }
        return (this.isOccupied);
    }

    public void setOccupied(String occupied) {
        this.isOccupied = occupied;
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