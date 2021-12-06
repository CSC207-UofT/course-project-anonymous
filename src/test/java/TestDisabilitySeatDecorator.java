import Entites.Seats.BusinessClassSeat;
import Entites.Seats.EconomySeat;
import Entites.Seats.FirstClassSeat;
import Entites.Seats.Seat;
import UseCases.decorators.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDisabilitySeatDecorator {
    DisabilitySeatDecorator disabilityEconomyDecorator;
    DisabilitySeatDecorator disabilityBusinessDecorator;
    DisabilitySeatDecorator disabilityFirstDecorator;


    @Before
    public void initializeManager() {
        Seat economy = new EconomySeat(111, 100);
        disabilityEconomyDecorator = new DisabilitySeatDecorator(economy);
        Seat business = new BusinessClassSeat(1111, 150);
        disabilityBusinessDecorator = new DisabilitySeatDecorator(business);
        Seat first = new FirstClassSeat(11111, 200);
        disabilityFirstDecorator = new DisabilitySeatDecorator(first);
    }

    @Test
    public void TestEconomyNumberOfCabinBagsAllowed() {
        Seat economy = new EconomySeat(111, 100);
        assertEquals(1, economy.numberOfCabinBagsAllowed());
        assertEquals(2, disabilityEconomyDecorator.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestEconomyNumberOfCheckInBagsAllowed() {
        Seat economy = new EconomySeat(111, 100);
        assertEquals(2, economy.numberOfCheckInBagsAllowed());
        assertEquals(3, disabilityEconomyDecorator.numberOfCheckInBagsAllowed());
    }

    @Test
    public void TestBusinessNumberOfCabinBagsAllowed() {
        Seat business = new BusinessClassSeat(1111, 150);
        assertEquals(2, business.numberOfCabinBagsAllowed());
        assertEquals(3, disabilityBusinessDecorator.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestBusinessNumberOfCheckInBagsAllowed() {
        Seat business = new BusinessClassSeat(1111, 150);
        assertEquals(2, business.numberOfCheckInBagsAllowed());
        assertEquals(3, disabilityBusinessDecorator.numberOfCheckInBagsAllowed());
    }

    @Test
    public void TestFirstNumberOfCabinBagsAllowed() {
        Seat first = new FirstClassSeat(11111, 200);
        assertEquals(2, first.numberOfCabinBagsAllowed());
        assertEquals(3, disabilityFirstDecorator.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestFirstNumberOfCheckInBagsAllowed() {
        Seat first = new FirstClassSeat(11111, 200);
        assertEquals(3, first.numberOfCheckInBagsAllowed());
        assertEquals(4, disabilityFirstDecorator.numberOfCheckInBagsAllowed());
    }
}
