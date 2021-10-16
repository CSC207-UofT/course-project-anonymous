import java.time.LocalDateTime;

public abstract class Seat implements BaggageAllowance, Refundable {
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

    @Override
    public int cabins() {
        return 1;
    }

    @Override
    public int checkInBags(Seat seat) {
        if (seat instanceof FirstClass) {
            return 2;
        } else if (seat instanceof BusinessClass) {
            return 2;
        } else {
            return 2;
        }
    }

    @Override
    public double refund(LocalDateTime departureDateTime) {
        return this.seatPrice;
    }


}