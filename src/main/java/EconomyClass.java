class EconomyClass extends Seat {

    public EconomyClass(int seatNumber, double seatPrice, boolean occupied) {
        super(seatNumber, seatPrice, occupied);
    }

    @Override
    public double getPrice() {
        return this.seatPrice;
    }

    @Override
    public void setPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

}