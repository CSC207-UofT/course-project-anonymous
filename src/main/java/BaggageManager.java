import java.util.ArrayList;

public class BaggageManager {
    // TODO: make this function non static
    static public double calculateTotalPrice(Seat seat, ArrayList<Baggage> baggages) {
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

    // TODO: maybe transfer function from ticket of add and remove baggage to here somehow
}
