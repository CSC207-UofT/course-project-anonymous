class FirstClass extends Seat {

    public FirstClass(int seatNumber, double seatPrice, boolean occupied) {
        super(seatNumber, seatPrice, occupied);
    }

    @Override
    public double getPrice() {
        return this.seatPrice + 100.0;
    }

    @Override
    public void setPrice(double seatPrice) {
        this.seatPrice = seatPrice + 100.0;
    }

}