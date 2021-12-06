package Entites;

public abstract class Baggage {

    public static final double cabinBagAllowance = 7;
    public static final double checkInBagAllowance = 23;

    public static final double extraCabinBagPrice = 15;
    public static final double extraCheckInBagPrice = 25;

    public static final double cabinBagCostOverweightPerKg = 10;
    public static final double checkInBagCostOverweightPerKg = 15;

    private int id;
    private double weight; private double width; private double height; // Dims. of the bag

    /**
     * Creates a new Baggage object with given weight, width, height
     *
     * @param weight: weight of this baggage.
     * @param width: width of this baggage.
     * @param height: height of this baggage.
     */

    public Baggage(double weight, double width, double height) {
        this.weight = weight; this.width = width; this.height = height;
        this.id = -1;
    }

    public abstract boolean isOverweight();

    // GETTERS AND SETTERS:

    /**
     * Gets the weight of a bag
     * @return returns the weight of the bag
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of a bag
     * @param weight takes the weight value of the bag
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *  Gets the width of a bag
     *
     * @return returns width of the bag
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of a bag
     *
     * @param width takes the width of a bag
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * gets the height of a bag
     *
     * @return returns the height of the bag
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of a bag
     *
     * @param height takes the height of the bag
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the id of a bag
     *
     * @return returns the id of the bag
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of a bag
     *
     * @param id takes the id of the bag
     */
    public void setId(int id) {
        this.id = id;
    }
}