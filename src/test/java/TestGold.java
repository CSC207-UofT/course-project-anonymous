import Entites.Memberships.Gold;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGold {
    Gold gold;

    @Before
    public void initializeManager() {
        gold = new Gold();
    }

    @Test
    public void TestGetFlightDiscount() {
        assertEquals(30, gold.getFlightDiscount(100), 0);
    }

    @Test
    public void TestGetMealDiscount() {
        assertEquals(6, gold.getMealDiscount(20), 0);
    }

    @Test
    public void TestGetExtraBaggageDiscount() {
        assertEquals(3, gold.getExtraBaggageDiscount(10), 0);
    }

    @Test
    public void TestGetMembershipName() {
        assertEquals("Gold", gold.getMembershipName());
    }
}