package Entites;

public class CabinBaggage extends Baggage {
    /**
     * Constructs a CabinBaggage, with the given weight, width, height
     * @param weight the weight of a bag
     * @param width the width of a bag
     * @param height the height of a bag
     */
    public CabinBaggage(double weight, double width, double height) {
        super(weight, width, height);
    }

    /**
     * Checks whether a bag is overweight or not
     *
     * @return returns true or false whether the bag is overweight
     */
    public boolean isOverweight() {
        return Baggage.cabinBagAllowance < Math.round(this.getWeight());
    }
}