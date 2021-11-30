import UseCases.decorators.*;
import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDisabilitySeatDecorator {
    DisabilitySeatDecorator disabilitySeatDecorator;

    @Before
    public void initializeManager() {
        Seat economy = new EconomySeat(111, 100);
        disabilitySeatDecorator = new DisabilitySeatDecorator(economy);
    }

    @Test
    public void TestNumberOfCabinBagsAllowed() {
        Seat economy = new EconomySeat(111, 100);
        assertEquals(1, economy.numberOfCabinBagsAllowed());
        assertEquals(2, disabilitySeatDecorator.numberOfCabinBagsAllowed());
    }

    @Test
    public void TestNumberOfCheckInBagsAllowed() {
        Seat economy = new EconomySeat(111, 100);
        assertEquals(2, economy.numberOfCheckInBagsAllowed());
        assertEquals(3, disabilitySeatDecorator.numberOfCheckInBagsAllowed());
    }
}
