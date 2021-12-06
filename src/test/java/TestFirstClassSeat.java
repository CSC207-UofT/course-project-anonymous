import Entites.Seats.FirstClassSeat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFirstClassSeat {
    FirstClassSeat firstClassSeat;

    @Before
    public void initializeManager() {
        firstClassSeat = new FirstClassSeat(1112, 200);
    }

    @Test
    public void TestNumberOfCabinBagsAllowed() {
        assertEquals(2, firstClassSeat.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestNumberOfCheckInBagsAllowed() {
        assertEquals(3, firstClassSeat.numberOfCheckInBagsAllowed());
    }

    @Test
    public void TestGetSeatClass() {
        assertEquals("First", firstClassSeat.getSeatClass());
    }

    @Test
    public void TestGetAndSetId() {
        assertEquals(1112, firstClassSeat.getId());
        firstClassSeat.setId(1234);
        assertEquals(1234, firstClassSeat.getId());
    }

    @Test
    public void TestGetAndSetOccupied() {
        firstClassSeat.setOccupied(true);
        assertTrue(firstClassSeat.getOccupied());
        firstClassSeat.setOccupied(false);
        assertFalse(firstClassSeat.getOccupied());
    }

    @Test
    public void TestGetAndSetPrice() {
        assertEquals(200, firstClassSeat.getPrice(), 0);
        firstClassSeat.setPrice(20);
        assertEquals(20, firstClassSeat.getPrice(), 0);
    }

    @Test
    public void TestGetOccupiedSymbol() {
        assertEquals("o", firstClassSeat.getOccupiedSymbol());
        firstClassSeat.setOccupied(true);
        assertEquals("x", firstClassSeat.getOccupiedSymbol());
        firstClassSeat.setOccupied(false);
        assertEquals("o", firstClassSeat.getOccupiedSymbol());
    }
}
