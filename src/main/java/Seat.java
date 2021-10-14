public abstract class Seat {
    int seatNumber;
    double seatPrice;
    boolean occupied;

    public Seat(int seatNumber, double seatPrice, boolean occupied) {
        this.seatNumber = seatNumber;
        this.seatPrice = seatPrice;
        this.occupied = occupied;
    }

    public abstract double getPrice();
    public abstract void setPrice(double seatPrice);
}