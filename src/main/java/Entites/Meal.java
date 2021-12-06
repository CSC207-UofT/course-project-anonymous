package Entites;

public class Meal {
    private String name; private boolean vegitarian;
    private double calories; private double price;

    /**
     *  Creates a meal with the given name, calorie count, price, and if
     *  it is vegetarian
     * @param name string name of the meal
     * @param calories calorie count of the meal
     * @param price the price of the meal
     * @param vegitarian whether the meal is vegetarian or not
     */

    public Meal(String name, double calories, double price, boolean vegitarian) {
        this.name = name; this.vegitarian = vegitarian;
        this.calories = calories; this.price = price;
    }

    /**
     *
     * @return returns the price of the meal
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return returns the calorie count of the meal
     */
    public double getCalories() {
        return calories;
    }

    /**
     *
     * @return returns the name of the meal
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return returns true if meal is vegetarian, returns false if not
     */
    public boolean isVegitarian() {
        return vegitarian;
    }
}