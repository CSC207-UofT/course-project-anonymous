// TODO:  maybe make this an interface and combine discountable and LoungeAccess to it
// This is because if we set to to an abs.class then we have to implement interfaces to it, which feels redundant.
public abstract class MembershipStatus implements discountable, LoungeAccess {

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
