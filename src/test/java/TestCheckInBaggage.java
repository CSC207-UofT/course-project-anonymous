import Entites.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCheckInBaggage {
    CheckInBaggage CheckInBaggage;

    @Before
    public void initializeManager(){
        CheckInBaggage = new CheckInBaggage(5.0, 5.0, 5.0);
    }

    @Test
    public void TestIsOverweight(){
        assertFalse(CheckInBaggage.isOverweight());
    }
}
