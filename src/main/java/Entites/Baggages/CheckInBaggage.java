package Entites.Baggages;

public class CheckInBaggage extends Baggage {
    /**
     * Constructs a CheckInBaggage with the given weight, width, height
     * @param weight weight of the bag
     * @param width width of the bag
     * @param height height of the bag
     */
    public CheckInBaggage(double weight, double width, double height) {
        super(weight, width, height);
    }

    /**
     * Checks whether a bag is overweight or not
     *
     * @return returns true or false that the assignment is overweight
     */
    public boolean isOverweight() {
        return Baggage.checkInBagAllowance < Math.round(this.getWeight());
    }
}
