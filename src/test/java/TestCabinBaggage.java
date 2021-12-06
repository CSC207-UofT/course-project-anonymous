import Entites.Baggages.CabinBaggage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCabinBaggage {
    CabinBaggage cabinBaggage;

    /**
     * Initializes a new CabinBaggage object for the test environment
     */
    @Before
    public void initializeManager(){
        cabinBaggage = new CabinBaggage(5.0, 5.0, 5.0);
    }

    /**
     * Verifies the function is returning the correct output if the bag is overweight
     */
    @Test
    public void TestIsOverweight(){
        assertFalse(cabinBaggage.isOverweight());
    }
}
