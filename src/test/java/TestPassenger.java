import Entites.Users.Passenger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPassenger {
    Passenger passenger;

    /**
     * initializes a passenger object for testing
     */
    @Before
    public void initializeManager(){
        passenger = new Passenger(1, "Kevin", "hello", "1234");
    }

    /**
     * tests the setPoints and getPoints functions of the passenger class for correct values
     */
    @Test
    public void TestPoints(){
        passenger.setPoints(5);
        assertEquals(5, passenger.getPoints());
    }

}
