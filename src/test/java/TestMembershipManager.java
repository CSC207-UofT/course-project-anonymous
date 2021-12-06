import UseCases.managers.MembershipManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMembershipManager {

    MembershipManager membershipManager;

    @Before
    public void initializeManager() {
        membershipManager = new MembershipManager();

    }

    @Test
    public void testCalculateLoungeAccess() {
        int time = membershipManager.calculateLoungeAccess(200);
        assertEquals((200 * 3) / 60, time);
    }

    @Test
    public void testCalculatePointsForLoungeHours() {
        int points = membershipManager.calculatePointsForLoungeHours(3);
        assertEquals((3 * 60) / 3, points);
    }
}
