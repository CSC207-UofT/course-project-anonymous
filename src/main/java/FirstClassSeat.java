public class FirstClassSeat extends Seat{

    private double price;

    public FirstClassSeat(int id, double price) {
        super(id);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculateRefundByDaysLeft(double price, int daysLeft) {
        return 0;
    }

    @Override
    public double calculateDateChangeChargeByDateLeft(double price, int daysLeft) {
        return 0;
    }

    @Override
    public int numberOfCabinBagsAllowed() {
        return 2;
    }

    @Override
    public int numberOfCheckInBagsAllowed() {
        return 3;
    }
}