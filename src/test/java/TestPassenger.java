import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPassenger {
    Passenger passenger;

    @Before
    public void initializeManager(){
        passenger = new Passenger(1, "Kevin", "hello", "1234");
    }

    @Test
    public void TestPoints(){
        passenger.setPoints(5);
        assertEquals(5, passenger.getPoints());
    }

}
