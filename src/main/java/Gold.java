public class Gold implements MembershipStatus {
    /**
     * return the price of the flight after a 30% discount
     * is applied
     *
     * @param price the flight's price
     *
     * @return the flight's discounted price
     **/
    @Override
    public double getFlightDiscount(double price) {
        return (price * 0.30);
    }

    /**
     * return the price of the meal after a 30% discount
     * is applied
     *
     * @param price the meal's price
     *
     * @return the meal's discounted price
     **/
    @Override
    public double getMealDiscount(double price) {
        return (price * 0.30);
    }

    /**
     * return the price of extra baggage after a 30% discount
     * is applied
     *
     * @param price the extra baggage price
     *
     * @return the extra baggage discounted price
     **/
    @Override
    public double getExtraBaggageDiscount(double price) {
        return (price * 0.30);
    }

    @Override
    public String getMembershipName() {
        return "Gold";
    }
}
