public class CabinBag extends Baggage{
    private boolean complimentary;

    public CabinBag(double weight, double width, double height, boolean complimentary){
        super(weight, width, height);
        this.complimentary = complimentary;
    }

    public boolean isComplimentary() {
        return complimentary;
    }
    public void setComplimentary(boolean bool){
        this.complimentary = bool;
    }

    public boolean isOverweight(double weight){
        return this.getweight() > 10;
    }
    public double OverweightCost(double weight){
        if (this.isOverweight(weight)){
            return (weight-10)*5;
        }
        else return 0;
    }
}
