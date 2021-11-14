import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestAirlineManager {
    AirlinesManager airlinesManager;
    @Before
    public void initializeManager() {
        airlinesManager = new AirlinesManager();
    }


    @Test
    public void testAddAirline(){
        assert(airlinesManager.airlines.size() == 0);
        airlinesManager.addAirline("Air India");
        airlinesManager.addAirline("Singapore Airlines");
        airlinesManager.addAirline("Air Canada");
        assert(airlinesManager.airlines.size() == 3);
        assertEquals("Air India", airlinesManager.airlines.get(0).name);
    }
    @Test
    public void testGetAirline(){
        airlinesManager.addAirline("Air India");
        airlinesManager.addAirline("Singapore Airlines");
        airlinesManager.addAirline("Air Canada");
        assertEquals(airlinesManager.airlines.get(0).name, airlinesManager.getAirline("Air India").name);
    }
}
