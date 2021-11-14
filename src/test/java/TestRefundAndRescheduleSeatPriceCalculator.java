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
    }
    @Test
    public void testcalculateDateChangeChargeByDateLeft(){
        double actual = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 7, 10);
        assert (actual == 0);
    }
}
