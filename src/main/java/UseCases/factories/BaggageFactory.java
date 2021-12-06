package UseCases.factories;

import Entites.Baggages.Baggage;
import Entites.Baggages.CabinBaggage;
import Entites.Baggages.CheckInBaggage;

import java.util.ArrayList;
import java.util.Map;

public class BaggageFactory {
    public ArrayList<Baggage> createBaggageList(ArrayList<Map<String, Double>> baggagesInfo) {
        ArrayList<Baggage> baggages = new ArrayList<>();

        for (Map<String, Double> baggageInfo : baggagesInfo) {
            double weight = baggageInfo.get("weight");
            double width = baggageInfo.get("width");
            double height = baggageInfo.get("height");

            if (Double.compare(baggageInfo.get("type") ,0.0) == 0) {
                baggages.add(new CabinBaggage(weight, width, height));
            } else {
                baggages.add(new CheckInBaggage(weight, width, height));
            }
        }

        return baggages;
    }

    public ArrayList<Baggage> createBaggagesForDataLoading(int noOfCabinBags, int noOfCheckInBags) {
        ArrayList<Baggage> baggages = new ArrayList<>();

        for (int i = 0; i < noOfCabinBags; i++) {
            baggages.add(new CabinBaggage(6, 7, 7));
        }

        for (int i = 0; i < noOfCheckInBags; i++) {
            baggages.add(new CheckInBaggage(20, 23, 23));
        }

        return baggages;
    }
}
