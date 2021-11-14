import UseCases.managers.AirlinesManager;
import org.junit.*;

import static org.junit.Assert.*;

public class TestAirlineManager {
    AirlinesManager airlinesManager;
    @Before
    public void initializeManager() {
        airlinesManager = new AirlinesManager();
    }


    @Test
    public void testAddAirline(){
        assert(airlinesManager.getAllAirlines().size() == 0);
        airlinesManager.addAirline("Air India");
        airlinesManager.addAirline("Singapore Airlines");
        airlinesManager.addAirline("Air Canada");
        assert(airlinesManager.getAllAirlines().size() == 3);
        assertEquals("Air India", airlinesManager.getAllAirlines().get(0).name);
    }
    @Test
    public void testGetAirline(){
        airlinesManager.addAirline("Air India");
        airlinesManager.addAirline("Singapore Airlines");
        airlinesManager.addAirline("Air Canada");
        assertEquals(airlinesManager.getAllAirlines().get(0).name, airlinesManager.getAirline("Air India").name);
    }
}
