import Entites.Seats.BusinessClassSeat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBusinessClassSeat {
    BusinessClassSeat businessClassSeat;

    @Before
    public void initializeManager() {
        businessClassSeat = new BusinessClassSeat(11111, 150);
    }

    @Test
    public void TestNumberOfCabinBagsAllowed() {
        assertEquals(2, businessClassSeat.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestNumberOfCheckInBagsAllowed() {
        assertEquals(2, businessClassSeat.numberOfCheckInBagsAllowed());
    }

    @Test
    public void TestGetSeatClass() {
        assertEquals("Business", businessClassSeat.getSeatClass());
    }

    @Test
    public void TestGetAndSetId() {
        assertEquals(11111, businessClassSeat.getId());
        businessClassSeat.setId(134);
        assertEquals(134, businessClassSeat.getId());
    }

    @Test
    public void TestGetAndSetOccupied() {
        businessClassSeat.setOccupied(true);
        assertTrue(businessClassSeat.getOccupied());
        businessClassSeat.setOccupied(false);
        assertFalse(businessClassSeat.getOccupied());
    }

    @Test
    public void TestGetAndSetPrice() {
        assertEquals(150, businessClassSeat.getPrice(), 0);
        businessClassSeat.setPrice(200);
        assertEquals(200, businessClassSeat.getPrice(), 0);
    }

    @Test
    public void TestGetOccupiedSymbol() {
        assertEquals("o", businessClassSeat.getOccupiedSymbol());
        businessClassSeat.setOccupied(true);
        assertEquals("x", businessClassSeat.getOccupiedSymbol());
        businessClassSeat.setOccupied(false);
        assertEquals("o", businessClassSeat.getOccupiedSymbol());
    }
}
