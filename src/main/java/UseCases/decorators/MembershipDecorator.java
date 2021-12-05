package UseCases.decorators;
import Entites.*;

public abstract class MembershipDecorator implements MembershipStatus {
    protected MembershipStatus decoratedMembership;

    /**
     * Construct a MembershipDecorator, giving it the given
     * MembershipStatus object.
     *
     * @param decoratedMembership A MembershipStatus object
     */
    public MembershipDecorator(MembershipStatus decoratedMembership){
        this.decoratedMembership = decoratedMembership;
    }

    /**
     * return the price of the flight after a discount
     * is applied
     *
     * @param price the flight's price
     *
     * @return the flight's discounted price
     **/
    public double getFlightDiscount(double price) {
        return decoratedMembership.getFlightDiscount(price);
    }

    /**
     * return the price of the meal after a discount
     * is applied
     *
     * @param price the meal's price
     *
     * @return the meal's discounted price
     **/
    public double getMealDiscount(double price) {
        return decoratedMembership.getMealDiscount(price);
    }

    /**
     * return the price of extra baggage after a discount
     * is applied
     *
     * @param price the extra baggage price
     *
     * @return the extra baggage discounted price
     **/
    public double getExtraBaggageDiscount(double price) {
        return decoratedMembership.getExtraBaggageDiscount(price);
    }

    /**
     * @return the name of the membership
     */
    public String getMembershipName() {
        return decoratedMembership.getMembershipName();
    }
}