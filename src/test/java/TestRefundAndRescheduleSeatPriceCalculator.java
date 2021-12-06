import Entites.EconomySeat;
import UseCases.helpers.RefundAndRescheduleSeatPriceCalculator;
import org.junit.*;

public class TestRefundAndRescheduleSeatPriceCalculator {
    EconomySeat seat;
    RefundAndRescheduleSeatPriceCalculator refundAndRescheduleSeatPriceCalculator;

    @Before
    public void initializeManager() {
        seat = new EconomySeat(1, 100);
        refundAndRescheduleSeatPriceCalculator = new RefundAndRescheduleSeatPriceCalculator();
    }
    @Test
    public void testcalculateRefundByDaysLeft(){
        double actual = refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(seat, 2);
        assert (actual == 50);
        double actual1 = refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(seat, 7);
        assert (actual1 == 100);
        double actual2 = refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(seat, 0);
        assert (actual2 == 0);
        double actual3 = refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(seat, 30);
        assert(actual3 == 100);
        double actual4 = refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(seat, 5);
        assert(actual4 == 80);

    }
    @Test
    public void testcalculateDateChangeChargeByDateLeft(){
        double actual = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 7, 10);
        assert (actual == 0);
        double actual1 = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 5, 10);
        assert (actual1 == 2);
        double actual2 = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 15, 10);
        assert (actual2 == 0);
    }
}
