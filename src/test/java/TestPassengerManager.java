import UseCases.managers.PassengerManager;
import org.junit.Before;
import org.junit.Test;

public class TestPassengerManager {
    PassengerManager passengerManager;

    @Before
    public void initializeManager() {
        passengerManager = new PassengerManager();
    }

    @Test
    public void testAddPassenger() {
        assert(passengerManager.getPassengers().size() == 0);

        int id = passengerManager.addPassenger("Eeshan", "eeshan.narula@gmail.com", "1234567");

        assert(passengerManager.getPassengers().size() == 1);
        assert(id == 0);
    }
}
