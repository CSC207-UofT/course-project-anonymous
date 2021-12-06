import Entites.Baggages.CheckInBaggage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCheckInBaggage {
    Entites.Baggages.CheckInBaggage CheckInBaggage;

    /**
     * initializes a new CheckInBaggage object for testing
     */
    @Before
    public void initializeManager(){
        CheckInBaggage = new CheckInBaggage(5.0, 5.0, 5.0);
    }

    /**
     * Verifies the function is returning the correct output if the bag is overweight
     */
    @Test
    public void TestIsOverweight(){
        assertFalse(CheckInBaggage.isOverweight());
    }
}
