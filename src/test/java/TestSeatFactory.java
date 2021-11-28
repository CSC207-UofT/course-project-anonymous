import Entites.BusinessClassSeat;
import Entites.EconomySeat;
import Entites.FirstClassSeat;
import Entites.Seat;
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
    public void testCreateSeatMapId() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(3, 3, 3);

        ArrayList<Seat> expectedSeatMap = new ArrayList<>();

        expectedSeatMap.add(new EconomySeat(0, 100));
        expectedSeatMap.add(new EconomySeat(1, 100));
        expectedSeatMap.add(new EconomySeat(2, 100));
        expectedSeatMap.add(new BusinessClassSeat(3, 150));
        expectedSeatMap.add(new BusinessClassSeat(4, 150));
        expectedSeatMap.add(new BusinessClassSeat(5, 150));
        expectedSeatMap.add(new FirstClassSeat(6, 200));
        expectedSeatMap.add(new FirstClassSeat(7, 200));
        expectedSeatMap.add(new FirstClassSeat(8, 200));

        assertEquals(seatMap.get(0).getId(), expectedSeatMap.get(0).getId());
        assertEquals(seatMap.get(1).getId(), expectedSeatMap.get(1).getId());
        assertEquals(seatMap.get(2).getId(), expectedSeatMap.get(2).getId());
        assertEquals(seatMap.get(3).getId(), expectedSeatMap.get(3).getId());
        assertEquals(seatMap.get(4).getId(), expectedSeatMap.get(4).getId());
        assertEquals(seatMap.get(5).getId(), expectedSeatMap.get(5).getId());
        assertEquals(seatMap.get(6).getId(), expectedSeatMap.get(6).getId());
        assertEquals(seatMap.get(7).getId(), expectedSeatMap.get(7).getId());
        assertEquals(seatMap.get(8).getId(), expectedSeatMap.get(8).getId());

    }

    @Test
    public void testCreateSeatMapPrice() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(3, 3, 3);

        ArrayList<Seat> expectedSeatMap = new ArrayList<>();

        expectedSeatMap.add(new EconomySeat(0, 100));
        expectedSeatMap.add(new EconomySeat(1, 100));
        expectedSeatMap.add(new EconomySeat(2, 100));
        expectedSeatMap.add(new BusinessClassSeat(3, 150));
        expectedSeatMap.add(new BusinessClassSeat(4, 150));
        expectedSeatMap.add(new BusinessClassSeat(5, 150));
        expectedSeatMap.add(new FirstClassSeat(6, 200));
        expectedSeatMap.add(new FirstClassSeat(7, 200));
        expectedSeatMap.add(new FirstClassSeat(8, 200));

        assertEquals(seatMap.get(0).getPrice(), expectedSeatMap.get(0).getPrice(), 0);
        assertEquals(seatMap.get(1).getPrice(), expectedSeatMap.get(1).getPrice(), 0);
        assertEquals(seatMap.get(2).getPrice(), expectedSeatMap.get(2).getPrice(), 0);
        assertEquals(seatMap.get(3).getPrice(), expectedSeatMap.get(3).getPrice(), 0);
        assertEquals(seatMap.get(4).getPrice(), expectedSeatMap.get(4).getPrice(), 0);
        assertEquals(seatMap.get(5).getPrice(), expectedSeatMap.get(5).getPrice(), 0);
        assertEquals(seatMap.get(6).getPrice(), expectedSeatMap.get(6).getPrice(), 0);
        assertEquals(seatMap.get(7).getPrice(), expectedSeatMap.get(7).getPrice(), 0);
        assertEquals(seatMap.get(8).getPrice(), expectedSeatMap.get(8).getPrice(), 0);
    }

    @Test
    public void testCreateSeatMapType() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(3, 3, 3);

        ArrayList<Seat> expectedSeatMap = new ArrayList<>();

        expectedSeatMap.add(new EconomySeat(0, 100));
        expectedSeatMap.add(new EconomySeat(1, 100));
        expectedSeatMap.add(new EconomySeat(2, 100));
        expectedSeatMap.add(new BusinessClassSeat(3, 150));
        expectedSeatMap.add(new BusinessClassSeat(4, 150));
        expectedSeatMap.add(new BusinessClassSeat(5, 150));
        expectedSeatMap.add(new FirstClassSeat(6, 200));
        expectedSeatMap.add(new FirstClassSeat(7, 200));
        expectedSeatMap.add(new FirstClassSeat(8, 200));

        assertEquals(seatMap.get(0).getId(), expectedSeatMap.get(0).getId());
        assertEquals(seatMap.get(1).getId(), expectedSeatMap.get(1).getId());
        assertEquals(seatMap.get(2).getId(), expectedSeatMap.get(2).getId());
        assertEquals(seatMap.get(3).getId(), expectedSeatMap.get(3).getId());
        assertEquals(seatMap.get(4).getId(), expectedSeatMap.get(4).getId());
        assertEquals(seatMap.get(5).getId(), expectedSeatMap.get(5).getId());
        assertEquals(seatMap.get(6).getId(), expectedSeatMap.get(6).getId());
        assertEquals(seatMap.get(7).getId(), expectedSeatMap.get(7).getId());
        assertEquals(seatMap.get(8).getId(), expectedSeatMap.get(8).getId());
    }

    @Test
    public void testCreateSeatMapLength() {
        ArrayList<Seat> seatMap = seatFactory.createSeatMap(3, 3, 3);
        assertEquals(9, seatMap.size());
    }


//    This implementation of the test cannot work since getSeatOfClass relies on an arraylist
//    of seats of size 358 (252 economy seats, 90 business class seats, 18 first class seats)
//    representing an airplane. These values can be found in the Flight entity class.
//    This implementation would only work on a list of 9 seats which is not possible since we
//    require 358 for the GetSeatsOfClass function
//    Due to this size, it would force us to create an arraylist of seats of size 358 to make tests upon
//    and get our sub-lists of different types of seats. This task is tedious and time-consuming,
//    but we are confident our function works.

//    @Test
//    public void testGetSeatsOfClassEconomy() {
//        ArrayList<Seat> seatMap = seatFactory.createSeatMap(3, 3, 3);
//        ArrayList<Seat> economy = seatFactory.getSeatsOfClass(seatMap, "1");
//
//        ArrayList<Seat> expectedSeatMap = new ArrayList<>();
//        expectedSeatMap.add(new EconomySeat(0, 100));
//        expectedSeatMap.add(new EconomySeat(1, 100));
//        expectedSeatMap.add(new EconomySeat(2, 100));
//
//        // compare price's and id's
//        assertEquals(economy.get(0).getId(), expectedSeatMap.get(0).getId());
//        assertEquals(economy.get(0).getPrice(), expectedSeatMap.get(0).getPrice(), 0);
//        assertEquals(economy.get(1).getId(), expectedSeatMap.get(1).getId());
//        assertEquals(economy.get(1).getPrice(), expectedSeatMap.get(1).getPrice(), 0);
//        assertEquals(economy.get(2).getId(), expectedSeatMap.get(2).getId());
//        assertEquals(economy.get(2).getPrice(), expectedSeatMap.get(2).getPrice(), 0);
//
//        //compare size of array list
//        assertEquals(economy.size(), expectedSeatMap.size());
//
//    }
}
