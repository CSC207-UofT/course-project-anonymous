import java.time.LocalDateTime;

class BusinessClass extends Seat {

    public BusinessClass(int seatNumber, double seatPrice, boolean occupied) {
        super(seatNumber, seatPrice, occupied);
    }

    @Override
    public double getPrice() {
        return this.seatPrice + 50.0;
    }

    @Override
    public void setPrice(double seatPrice) {
        this.seatPrice = seatPrice + 50.0;
    }

    @Override
    public int cabins() {
        return 1;
    }

    @Override
    public int checkInBags(Seat seat) {

        return 1;
    }

    @Override
    public double refund(LocalDateTime departureDateTime) {
        return this.seatPrice; // full refund
    }

}