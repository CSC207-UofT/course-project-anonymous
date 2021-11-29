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
        double full_refund = seatManager.calculateRefundByDaysLeft(7, 28);
        assertEquals(200, full_refund, 0);

        double partial_refund = seatManager.calculateRefundByDaysLeft(2, 28);
        assertEquals(148, partial_refund, 0);

        double no_refund = seatManager.calculateRefundByDaysLeft(0, 28);
        assertEquals(0, no_refund, 0);

    }

    @Test
    public void testCalculateDateChangeChargeByDateLeft() {
        double no_charge = seatManager.calculateDateChangeChargeByDateLeft(7, 28);
        assertEquals(0, no_charge, 0);

        // charged $50 if date is changed 3 days before the departure date
        double charge = seatManager.calculateDateChangeChargeByDateLeft(3, 28);
        assertEquals(50, charge, 0);
    }
}
