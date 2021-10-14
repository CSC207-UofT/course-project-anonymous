package main;

/** name represents what the selected meal is called. A string description
 * calories represents how many measured calories are in the meal
 * cost represents how much the meal is in dollars.
 * isVeg is true when the meal is vegetarian and false otherwise.
 */



public class meal {

    private String name;
    private int calories;
    private double cost;
    private boolean isVeg;

    public meal(String name, int calories, double cost, boolean isVeg) {
    this.name =name;
    this.calories =calories;
    this.cost =cost;
    this.isVeg =isVeg;
    }

    public boolean getVeg() {
        return this.isVeg;
    }


    public String getName() {
        return this.name;
    }

    public int getCalories() {

        return this.calories;
    }

    public double getCost() {

        return this.cost;
    }

}
