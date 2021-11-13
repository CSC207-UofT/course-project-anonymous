import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaggageManager_Test {

    BaggageManager baggageManager;
    Seat first;
    Seat economy;
    Baggage cabin;
    Baggage checked_in;
    ArrayList<Baggage> bag_list = new ArrayList<Baggage>();

    @Before
    public void initializeManager() {
        baggageManager = new BaggageManager();
        first = new FirstClassSeat(123,4893);
        economy = new EconomySeat(235,327);
        cabin = new CabinBaggage(12.1,11.1,32.0);
        checked_in = new CabinBaggage(13.4,5.3,15.8);
        bag_list.add(cabin);
        bag_list.add(checked_in);
    }

    @Test
    public void testBaggagePassenger() {

        assert(baggageManager.calculateTotalPrice(first, bag_list) != 45.5);

        assert(baggageManager.calculateTotalPrice(economy, bag_list) != 4.44);

    }



}
