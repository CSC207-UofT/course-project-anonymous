public class Gold implements MembershipStatus {
    /**
     * return the price of the flight after a discount
     * is applied
     *
     * @param price the flight's price
     *
     * @return the flight's discounted price
     **/
    @Override
    public double getFlightDiscount(double price) {
        return 0;
    }

    /**
     * return the price of the meal after a discount
     * is applied
     *
     * @param price the meal's price
     *
     * @return the meal's discounted price
     **/
    @Override
    public double getMealDiscount(double price) {
        return 0;
    }

    /**
     * return the price of extra baggage after a discount
     * is applied
     *
     * @param price the extra baggage price
     *
     * @return the extra baggage discounted price
     **/
    @Override
    public double getExtraBaggageDiscount(double price) {
        return 0;
    }

    /**
     * calculates the time for how long you can access the lounge
     * based on how many membership points a user has
     *
     * @param points a user's membership points
     *
     * @return how long the user can access the lounge
     **/
    @Override
    public int calculateLoungeAccess(int points) {
        return 0;
    }

    /**
     * calculates how many points will be used based on how
     * many hours the user wants to stay in the lounge
     *
     * @param hours the amount of time the user stays at a lounge
     *
     * @return how many points will be deducted based on their stay
     **/
    @Override
    public int calculatePointsForLoungeHours(int hours) {
        return 0;
    }
}