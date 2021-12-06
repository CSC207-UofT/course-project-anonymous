import Entites.Memberships.Silver;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSilver {
    Silver silver;

    @Before
    public void initializeManager() {
        silver = new Silver();
    }

    @Test
    public void TestGetFlightDiscount() {
        assertEquals(20, silver.getFlightDiscount(100), 0);
    }

    @Test
    public void TestGetMealDiscount() {
        assertEquals(4, silver.getMealDiscount(20), 0);
    }

    @Test
    public void TestGetExtraBaggageDiscount() {
        assertEquals(2, silver.getExtraBaggageDiscount(10), 0);
    }

    @Test
    public void TestGetMembershipName() {
        assertEquals("Silver", silver.getMembershipName());
    }
}