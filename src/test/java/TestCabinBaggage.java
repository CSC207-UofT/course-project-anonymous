import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCabinBaggage {
    CabinBaggage cabinBaggage;

    @Before
    public void initializeManager(){
        cabinBaggage = new CabinBaggage(5.0, 5.0, 5.0);
    }

    @Test
    public void TestIsOverweight(){
        assertFalse(cabinBaggage.isOverweight());
    }
}
