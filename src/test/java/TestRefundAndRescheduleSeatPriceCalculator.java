import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;

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

    }
    @Test
    public void testcalculateDateChangeChargeByDateLeft(){
        double actual = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 7, 10);
        assert (actual == 0);
        double actual1 = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(seat, 5, 10);
        assert (actual1 == 2);
    }
}
