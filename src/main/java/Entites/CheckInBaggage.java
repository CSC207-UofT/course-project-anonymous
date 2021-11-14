package Entites;

public class CheckInBaggage extends Baggage {
    public CheckInBaggage(double weight, double width, double height) {
        super(weight, width, height);
    }

    public boolean isOverweight() {
        return Baggage.checkInBagAllowance < Math.round(this.getWeight());
    }
}
