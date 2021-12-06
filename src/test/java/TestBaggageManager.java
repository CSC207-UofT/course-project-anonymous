import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Baggages.CheckInBaggage;
import Entites.Memberships.Seats.EconomySeat;
import Entites.Memberships.Seats.FirstClassSeat;
import Entites.Memberships.Seats.Seat;
import UseCases.managers.BaggageManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestBaggageManager {

    BaggageManager baggageManager;
    Seat first;
    Seat economy;
    Baggage cabin1;
    Baggage cabin2;
    Baggage checked_in1;
    Baggage checked_in2;
    Baggage checked_in3;
    ArrayList<Baggage> bag_list = new ArrayList<Baggage>();

    @Before
    public void initializeManager() {
        /**
         * Creating a baggage list and adding checked-in and cabin baggage to it
         */
        baggageManager = new BaggageManager();
        first = new FirstClassSeat(123,4893);
        economy = new EconomySeat(235,327);
        cabin1 = new CabinBaggage(12.1,11.1,32.0);
        cabin2 = new CabinBaggage(10.2,3.3,4.3);
        checked_in1 = new CheckInBaggage(13.4,5.3,15.8);
        checked_in2 = new CheckInBaggage(5.5,4.5,11.3);
        checked_in3 = new CheckInBaggage(7.4,6.3,10.9);
        bag_list.add(cabin1);
        bag_list.add(cabin2);
        bag_list.add(checked_in1);
        bag_list.add(checked_in2);
        bag_list.add(checked_in3);
    }

    @Test
    public void testBaggageManager() {
        // Checking that the total price after discounts and membership benefits are applied remains a positive number
        assert(baggageManager.calculateTotalPrice(first, bag_list) > 0.0);
        assert(baggageManager.calculateTotalPrice(economy, bag_list) > 0.0);

        // Checking that the total number of Cabin baggages is correctly returned
        assert(baggageManager.noOfCabinBags(bag_list) == 2);

        // Checking that the total number of Checked-in baggages is correctly returned
        assert(baggageManager.noOfCheckInBags(bag_list) == 3);

    }



}
