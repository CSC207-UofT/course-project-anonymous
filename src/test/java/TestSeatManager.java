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
        assertEquals(200, full_refund);

        double partial_refund = seatManager.calculateRefundByDaysLeft(2, 28);
        assertEquals(148, partial_refund);

        double no_refund = seatManager.calculateRefundByDaysLeft(0, 28);
        assertEquals(0, no_refund);

    }

    @Test
    public void testCalculateDateChangeChargeByDateLeft() {
        double no_charge = seatManager.calculateDateChangeChargeByDateLeft(7, 28);
        assertEquals(0, no_charge);

        // charged $50 if date is changed 3 days before the departure date
        double charge = seatManager.calculateDateChangeChargeByDateLeft(3, 28);
        assertEquals(50, charge);
    }
}
