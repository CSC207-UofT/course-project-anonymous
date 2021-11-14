import Entites.*;
import UseCases.factories.MembershipFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMembershipFactory {
    MembershipFactory membershipFactory;

    @Before
    public void initializeManager() {
        membershipFactory = new MembershipFactory();
    }

    @Test
    public void testGetMembership() {
        MembershipStatus standard = membershipFactory.getMembership("STANDARD");
        assertTrue(standard instanceof Standard);

        MembershipStatus silver = membershipFactory.getMembership("SILVER");
        assertTrue(silver instanceof Silver);

        MembershipStatus gold = membershipFactory.getMembership("GOLD");
        assertTrue(gold instanceof Gold);

        MembershipStatus platinum = membershipFactory.getMembership("PLATINUM");
        assertTrue(platinum instanceof Platinum);
    }

    @Test
    public void testSetMembership() {
        Passenger passenger = new Passenger(111, "Dinkar", "dv@gmail.com", "123-456-3434");
        int[] pointsThreshold = new int[]{0, 100, 200, 300};

        // passenger has a Entites.Standard membership with 20 points
        passenger.setPoints(20);
        passenger.setMembership(new Standard());

        // increase points to 199
        passenger.setPoints(199);

        // since we increased passengers points to 199, their membership should change to silver
        membershipFactory.setMembership(passenger, pointsThreshold);
        assertTrue(passenger.getMembership() instanceof Silver);
    }


    @Test
    public void testCalculateLoungeAccess() {
        int time = membershipFactory.calculateLoungeAccess(200);
        assertEquals((200 * 3) / 60, time);
    }

    @Test
    public void testCalculatePointsForLoungeHours() {
        int points = membershipFactory.calculatePointsForLoungeHours(3);
        assertEquals((3 * 60) / 3, points);
    }
}
