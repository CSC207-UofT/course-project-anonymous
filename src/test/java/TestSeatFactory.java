import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSeatFactory {
    SeatFactory seatFactory;

    @Before
    public void initializeManager() {
        seatFactory = new SeatFactory();
    }

    @Test
    public void testGetMembership() {
        Seat economy = seatFactory.getSeat("ECONOMYSEAT", 111, 200);
        assertTrue(economy instanceof EconomySeat);

        Seat first = seatFactory.getSeat("FIRSTCLASSSEAT", 1111, 1000);
        assertTrue(first instanceof FirstClassSeat);

        Seat business = seatFactory.getSeat("BUSINESSCLASSSEAT", 11111, 400);
        assertTrue(business instanceof BusinessClassSeat);
    }
}
