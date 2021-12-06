import Entites.Memberships.Platinum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlatinum {
    Platinum platinum;

    @Before
    public void initializeManager() {
        platinum = new Platinum();
    }

    @Test
    public void TestGetFlightDiscount() {
        assertEquals(40, platinum.getFlightDiscount(100), 0);
    }

    @Test
    public void TestGetMealDiscount() {
        assertEquals(8, platinum.getMealDiscount(20), 0);
    }

    @Test
    public void TestGetExtraBaggageDiscount() {
        assertEquals(4, platinum.getExtraBaggageDiscount(10), 0);
    }

    @Test
    public void TestGetMembershipName() {
        assertEquals("Platinum", platinum.getMembershipName());
    }
}