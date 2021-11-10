public interface MembershipStatus {
    // TODO delete discountable and loungeaccess since they're redundant
    /**
     * return the price of the flight after a discount
     * is applied
     *
     * @param price the flight's price
     *
     * @return the flight's discounted price
     **/
    double getFlightDiscount(double price);

    /**
     * return the price of the meal after a discount
     * is applied
     *
     * @param price the meal's price
     *
     * @return the meal's discounted price
     **/
    double getMealDiscount(double price);

    /**
     * return the price of extra baggage after a discount
     * is applied
     *
     * @param price the extra baggage price
     *
     * @return the extra baggage discounted price
     **/
    double getExtraBaggageDiscount(double price);

    /**
     * calculates the time for how long you can access the lounge
     * based on how many membership points a user has
     *
     * @param points a user's membership points
     *
     * @return how long the user can access the lounge
     **/
    int calculateLoungeAccess(int points);

    /**
     * calculates how many points will be used based on how
     * many hours the user wants to stay in the lounge
     *
     * @param hours the amount of time the user stays at a lounge
     *
     * @return how many points will be deducted based on their stay
     **/
    int calculatePointsForLoungeHours(int hours);
}
