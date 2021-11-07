import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestPassengerManager {
    PassengerManager passengerManager;

    @Before
    public void initializeManager() {
        passengerManager = new PassengerManager();
    }

    @Test
    public void testAddPassenger() {
        assert(passengerManager.passengers.size() == 0);

        int id = passengerManager.addPassenger("Eeshan", "eeshan.narula@gmail.com", "1234567");

        assert(passengerManager.passengers.size() == 1);
        assert(id == 0);
    }
}
