import java.util.ArrayList;

public class BaggageManager {
     public double calculateTotalPrice(Seat seat, ArrayList<Baggage> baggages) {
        /*
        Calculate the total price of list of baggages carried by a passenger. It takes in
        the list of baggages and add up the overweight cost, and the cost of extra bags
        that are not included.

        The number of allowed bags can be taken out of seat class, seat.numberOfCabinBagsAllowed()
                                                               or, seat.numberOfCheckInBagsAllowed()

        TODO: there is repeated code for Cabin (line 22-28) and CheckIn (line 29-36) if block.
         */
        int noOfCabinBags = 0;
        int noOfCheckinBags = 0;

        double totalCost = 0;

        for (Baggage b : baggages) {
            totalCost += this.calcOverweightPrice(b);

            if (b instanceof CabinBaggage) {
                noOfCabinBags++;
                if (noOfCabinBags > seat.numberOfCabinBagsAllowed()) {
                    totalCost += Baggage.extraCabinBagPrice;
                }
            } else {
                noOfCheckinBags++;
                if (noOfCheckinBags > seat.numberOfCheckInBagsAllowed()) {
                    totalCost += Baggage.extraCheckInBagPrice;
                }
            }
        }

        return totalCost;
    }

    public int noOfCabinBags(ArrayList<Baggage> baggages) {
        int count = 0;

        for (Baggage b: baggages) {
            if (b instanceof CabinBaggage) {
                count++;
            }
        }
        // |
        return count;
    }

    public int noOfCheckInBags(ArrayList<Baggage> baggages) {
        int count = 0;
        // |
        for (Baggage b: baggages) {
            if (b instanceof CheckInBaggage) {
                count++;
            }
        }

        return count;
    }

    public double calcOverweightPrice(Baggage baggage) {
        /*
        Calculate the overweight by the formula:

               overweight price per kg * round(bag weight - allowed weight)
         */
        if (baggage.isOverweight()) {
            double allowed_weight = 0;
            double per_kg_price = 0;

            if (baggage instanceof CabinBaggage) {
                allowed_weight = Baggage.cabinBagAllowance;
                per_kg_price = Baggage.cabinBagCostOverweightPerKg;
            } else {
                allowed_weight = Baggage.checkInBagAllowance;
                per_kg_price = Baggage.checkInBagCostOverweightPerKg;
            }
            return Math.max((Math.round(baggage.getWeight()) - allowed_weight)
                    * per_kg_price, 0);
        }
        return 0.0;
    }
}
