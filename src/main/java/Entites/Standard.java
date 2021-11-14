package Entites;

public class Standard implements MembershipStatus {

    /**
     * return the price of the flight after a 10% discount
     * is applied
     *
     * @param price the flight's price
     * @return the flight's discounted price
     **/
    @Override
    public double getFlightDiscount(double price) {
        return (price * 0.10);
    }

    /**
     * return the price of the meal after a 10% discount
     * is applied
     *
     * @param price the meal's price
     * @return the meal's discounted price
     **/
    @Override
    public double getMealDiscount(double price) {
        return (price * 0.10);
    }

    /**
     * return the price of extra baggage after a 10% discount
     * is applied
     *
     * @param price the extra baggage price
     * @return the extra baggage discounted price
     **/
    @Override
    public double getExtraBaggageDiscount(double price) {
        return (price * 0.10);
    }

    @Override
    public String getMembershipName() {
        return "Standard";
    }
}
