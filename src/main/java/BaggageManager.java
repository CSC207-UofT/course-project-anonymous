import java.util.ArrayList;

public class BaggageManager {
    static public double calculateTotalPrice(Seat seat, ArrayList<Baggage> baggages) {
        int noOfCabinBags = 0;
        int noOfCheckinBags = 0;

        double totalCost = 0;

        for (Baggage b : baggages) {
            if (b instanceof CabinBaggage) {
                totalCost += ((CabinBaggage) b).calcOverweightPrice();

                noOfCabinBags++;
                if (noOfCabinBags > seat.numberOfCabinBagsAllowed()) {
                    totalCost += Baggage.extraCabinBagPrice;
                }
            } else if (b instanceof CheckInBaggage) {
                totalCost += ((CheckInBaggage) b).calcOverweightPrice();

                noOfCheckinBags++;
                if (noOfCheckinBags > seat.numberOfCheckInBagsAllowed()) {
                    totalCost += Baggage.extraCheckInBagPrice;
                }
            }
        }

        return totalCost;
    }
}
