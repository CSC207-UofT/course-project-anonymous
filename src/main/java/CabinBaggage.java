public class CabinBaggage extends Baggage {

    public CabinBaggage(double weight, double width, double height) {
        super(weight, width, height);
    }

    public boolean isOverweight() {
        return Baggage.cabinBagAllowance < Math.round(this.getWeight());
    }

    public double calcOverweightPrice() {
        /*
        Calculate the overweight by the formula:

               overweight price per kg * round(bag weight - allowed weight)

        TODO: implement this method correctly
        TODO: shift this method to baggage manager
         */
        return Math.max((Math.round(this.getWeight()) - Baggage.cabinBagAllowance)
                        * Baggage.cabinBagCostOverweightPerKg, 0);
    }
}