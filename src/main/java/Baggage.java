public abstract class Baggage {

    static final double cabinBagAllowance = 7;
    static final double checkInBagAllowance = 23;

    static final double extraCabinBagPrice = 15;
    static final double extraCheckInBagPrice = 25;

    static final double cabinBagCostOverweightPerKg = 10;
    static final double checkInBagCostOverweightPerKg = 15;

    private int id;
    private double weight; private double width; private double height; // Dims. of the bag

    public Baggage(double weight, double width, double height) {
       /**
        * Creates a new Baggage.
        *
        * @param weight: weight of this baggage.
        * @param width: width of this baggage.
        * @param height: height of this baggage.
        */
        
        this.weight = weight; this.width = width; this.height = height;
        this.id = -1;
    }

    public abstract boolean isOverweight();

    // GETTERS AND SETTERS:

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}