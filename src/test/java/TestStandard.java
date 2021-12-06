import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestStandard {
    Standard standard;

    @Before
    public void initializeManager() {
        standard = new Standard();
    }

    @Test
    public void TestGetFlightDiscount() {
        assertEquals(10, standard.getFlightDiscount(100), 0);
    }

    @Test
    public void TestGetMealDiscount() {
        assertEquals(2, standard.getMealDiscount(20), 0);
    }

    @Test
    public void TestGetExtraBaggageDiscount() {
        assertEquals(1, standard.getExtraBaggageDiscount(10), 0);
    }

    @Test
    public void TestGetMembershipName() {
        assertEquals("Standard", standard.getMembershipName());
    }
}
