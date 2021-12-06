import Entites.EconomySeat;
import Entites.Seat;
import UseCases.managers.SeatManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSeatManager {
    SeatManager seatManager;

    @Before
    public void initializeManager() {
        Seat seat = new EconomySeat(111, 200);
        seatManager = new SeatManager(seat);
    }

    @Test
    public void testCalculateRefundByDaysLeft() {
        // Given full refund if ticket is cancelled 7 days before departure
        double full_refund = seatManager.calculateRefundByDaysLeft(7, 28);
 
        assertEquals(200, full_refund, 0);


        // Given partial refund of $148 if ticket is cancelled 2 days before departure
        double partial_refund = seatManager.calculateRefundByDaysLeft(2, 28);

        assertEquals(148, partial_refund, 0);


        // Given partial refund of $180 if ticket is cancelled 5 days before departure
        double partial_refund2 = seatManager.calculateRefundByDaysLeft(5, 15);
        System.out.println(partial_refund2);
        assertEquals(180.0, partial_refund2,0);

        // Given no refund if ticket is cancelled just before departure
        double no_refund = seatManager.calculateRefundByDaysLeft(0, 28);

        assertEquals(0, no_refund, 0);
    }

    @Test
    public void testCalculateDateChangeChargeByDateLeft() {
        // charged $0 if date is changed 7 days before the departure date
        double no_charge = seatManager.calculateDateChangeChargeByDateLeft(7, 28);

        assertEquals(0, no_charge, 0);

        // charged $50 if date is changed 3 days before the departure date
        double charge = seatManager.calculateDateChangeChargeByDateLeft(3, 28);
        assertEquals(50, charge, 0);
    }
}
