package UseCases.decorators;

import Entites.MembershipStatus;

public class DisabilityMembershipDecorator extends MembershipDecorator{

    static double disabilityDiscount = 0.10;
    /**
     * Construct a DisabilityMembershipDecorator, giving it the given
     * MembershipStatus object.
     *
     * @param decoratedMembership A MembershipStatus object
     */
    public DisabilityMembershipDecorator(MembershipStatus decoratedMembership){
        super(decoratedMembership);
    }

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
        return decoratedMembership.getFlightDiscount(price) * disabilityDiscount;
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
        return decoratedMembership.getMealDiscount(price) * disabilityDiscount;
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
        return decoratedMembership.getExtraBaggageDiscount(price) * disabilityDiscount;
    }

    /**
     * @return the name of the membership
     */
    @Override
    public String getMembershipName() {
        return decoratedMembership.getMembershipName();
    }
}
