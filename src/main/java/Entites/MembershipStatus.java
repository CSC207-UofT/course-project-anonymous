package Entites;

public interface MembershipStatus {
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
     * @return the name of the membership
     */
    String getMembershipName();
}
