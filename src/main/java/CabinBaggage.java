public class CabinBaggage extends Baggage {

    public CabinBaggage(double weight, double width, double height) {
        super(weight, width, height);
    }

    public boolean isOverweight() {
        return Baggage.cabinBagAllowance < Math.round(this.getWeight());
    }

    public double calcOverweightPrice() {
        return Math.max((Math.round(this.getWeight()) - Baggage.cabinBagAllowance)
                        * Baggage.cabinBagCostOverweightPerKg, 0);
    }
}