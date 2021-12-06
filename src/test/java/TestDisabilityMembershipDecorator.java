import UseCases.decorators.*;
import Entites.*;
import org.junit.Before;
import org.junit.Test;

public class TestDisabilityMembershipDecorator {
    DisabilityMembershipDecorator disabilityMembershipDecorator;

    @Before
    public void initializeManager() {
        MembershipStatus gold = new Gold();
        disabilityMembershipDecorator = new DisabilityMembershipDecorator(gold);
    }

    @Test
    public void testGetFlightDiscount(){
        /**
         * Checking that getFlightDiscount method works correctly
         */
        double test1 = disabilityMembershipDecorator.getFlightDiscount(230.00);
        assert(test1 == 6.9);
    }

    @Test
    public void testGetMealDiscount(){
        /**
         * Checking that getMealDiscount method works correctly
         */
        double test2 = disabilityMembershipDecorator.getMealDiscount(45.00);
        assert (test2 == 1.35);
    }

    @Test
    public void testGetExtraBaggageDiscount(){
        /**
         * Checking that getExtraBaggageDiscount method works correctly
         */
        double test3 = disabilityMembershipDecorator.getExtraBaggageDiscount(100.00);
        assert (test3 == 3.0);
    }

    @Test
    public void testGetMembershipName(){
        /**
         * Checking that getMembershipName method works correctly
         */
        String test4 = disabilityMembershipDecorator.getMembershipName();
        assert (test4.equals("Gold"));
    }
}
