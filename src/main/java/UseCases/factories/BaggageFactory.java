package UseCases.factories;

import Entites.Baggage;
import Entites.CabinBaggage;
import Entites.CheckInBaggage;

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
}
