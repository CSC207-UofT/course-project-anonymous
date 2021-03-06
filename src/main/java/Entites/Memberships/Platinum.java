package Entites.Memberships;

public class Platinum implements MembershipStatus {

    static double discount = 0.40;

    /**
     * return the price of the flight after a 40% discount
     * is applied
     *
     * @param price the flight's price
     *
     * @return the flight's discounted price
     **/
    @Override
    public double getFlightDiscount(double price) {
        return (price * discount);
    }

    /**
     * return the price of the meal after a 40% discount
     * is applied
     *
     * @param price the meal's price
     *
     * @return the meal's discounted price
     **/
    @Override
    public double getMealDiscount(double price) {
        return (price * discount);
    }

    /**
     * return the price of extra baggage after a 40% discount
     * is applied
     *
     * @param price the extra baggage price
     *
     * @return the extra baggage discounted price
     **/
    @Override
    public double getExtraBaggageDiscount(double price) {
        return (price * discount);
    }

    @Override
    public String getMembershipName() {
        return "Platinum";
    }
}
