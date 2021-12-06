import Entites.Memberships.Seats.BusinessClassSeat;
import Entites.Memberships.Seats.EconomySeat;
import Entites.Memberships.Seats.FirstClassSeat;
import Entites.Memberships.Seats.Seat;
import UseCases.factories.SeatFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestSeatFactory {
    SeatFactory seatFactory;

    @Before
    public void initializeManager() {
        seatFactory = new SeatFactory();
    }

    @Test
    public void testGetSeat() {
        Seat economy = seatFactory.getSeat("ECONOMYSEAT", 111, 200);
        assertTrue(economy instanceof EconomySeat);

        Seat first = seatFactory.getSeat("FIRSTCLASSSEAT", 1111, 1000);
        assertTrue(first instanceof FirstClassSeat);

        Seat business = seatFactory.getSeat("BUSINESSCLASSSEAT", 11111, 400);
        assertTrue(business instanceof BusinessClassSeat);
    }

    @Test
    public void testCreateSeatMap() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(252, 90, 18);

        assertEquals(360, seatMap.size());

        for (int i = 0; i < seatMap.size(); i++) {
            if (i < 252) {
                assertEquals("Economy", seatMap.get(i).getSeatClass());
                assertEquals(100, seatMap.get(i).getPrice(), 0);
                assertEquals(i, seatMap.get(i).getId());
            } else if (i < 342) {
                assertEquals("Business", seatMap.get(i).getSeatClass());
                assertEquals(150, seatMap.get(i).getPrice(), 0);
                assertEquals(i, seatMap.get(i).getId());
            } else {
                assertEquals("First", seatMap.get(i).getSeatClass());
                assertEquals(200, seatMap.get(i).getPrice(), 0);
                assertEquals(i, seatMap.get(i).getId());
            }
        }
    }

    @Test
    public void testGetSeatsOfClassEconomy() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(252, 90, 18);
        ArrayList<Seat> economy = seatFactory.getSeatsOfClass(seatMap, "1");

        assertEquals(252, economy.size());

        for (int i = 0; i < economy.size(); i++) {
            assertEquals("Economy", economy.get(i).getSeatClass());
            assertEquals(100, economy.get(i).getPrice(), 0);
            assertEquals(i, economy.get(i).getId());
        }
    }

    @Test
    public void testGetSeatsOfClassBusiness() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(252, 90, 18);
        ArrayList<Seat> businessClass = seatFactory.getSeatsOfClass(seatMap, "2");

        assertEquals(90, businessClass.size());

        for (int i = 0; i < businessClass.size(); i++) {
            assertEquals("Business", businessClass.get(i).getSeatClass());
            assertEquals(150, businessClass.get(i).getPrice(), 0);
            assertEquals(i + 252, businessClass.get(i).getId());
        }
    }

    @Test
    public void testGetSeatsOfClassFirst() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(252, 90, 18);
        ArrayList<Seat> firstClass = seatFactory.getSeatsOfClass(seatMap, "3");

        assertEquals(18, firstClass.size());

        for (int i = 0; i < firstClass.size(); i++) {
            assertEquals("First", firstClass.get(i).getSeatClass());
            assertEquals(200, firstClass.get(i).getPrice(), 0);
            assertEquals(i + 252 + 90, firstClass.get(i).getId());
        }
    }
}
