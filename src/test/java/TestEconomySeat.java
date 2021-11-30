import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEconomySeat {
    EconomySeat economySeat;

    @Before
    public void initializeManager() {
        economySeat = new EconomySeat(111, 100);
    }

    @Test
    public void TestNumberOfCabinBagsAllowed() {
        assertEquals(1, economySeat.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestNumberOfCheckInBagsAllowed() {
        assertEquals(2, economySeat.numberOfCheckInBagsAllowed());
    }

    @Test
    public void TestGetSeatClass() {
        assertEquals("Economy", economySeat.getSeatClass());
    }

    @Test
    public void TestGetAndSetId() {
        assertEquals(111, economySeat.getId());
        economySeat.setId(1234);
        assertEquals(1234, economySeat.getId());
    }

    @Test
    public void TestGetAndSetOccupied() {
        economySeat.setOccupied(true);
        assertTrue(economySeat.getOccupied());
        economySeat.setOccupied(false);
        assertFalse(economySeat.getOccupied());
    }

    @Test
    public void TestGetAndSetPrice() {
        assertEquals(100, economySeat.getPrice(), 0);
        economySeat.setPrice(20);
        assertEquals(20, economySeat.getPrice(), 0);
    }

    @Test
    public void TestGetOccupiedSymbol() {
        assertEquals("o", economySeat.getOccupiedSymbol());
        economySeat.setOccupied(true);
        assertEquals("x", economySeat.getOccupiedSymbol());
        economySeat.setOccupied(false);
        assertEquals("o", economySeat.getOccupiedSymbol());
    }
}
