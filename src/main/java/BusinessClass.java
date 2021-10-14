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

}