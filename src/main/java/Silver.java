public class Silver implements MembershipStatus {
    @Override
    public double getFlightDiscount(double price) {
        return 0;
    }

    @Override
    public double getMealDiscount(double price) {
        return 0;
    }

    @Override
    public double getExtraBaggageDiscount(double price) {
        return 0;
    }

    @Override
    public int calculateLoungeAccess(int points) {
        return 0;
    }

    @Override
    public int calculatePointsForLoungeHours(int hours) {
        return 0;
    }
}
