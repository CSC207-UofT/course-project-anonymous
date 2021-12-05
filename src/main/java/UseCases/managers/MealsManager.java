package UseCases.managers;

import Entites.Meal;

import java.util.ArrayList;
import java.util.Iterator;

import UseCases.GeneralIterator;


public class MealsManager implements Iterable<Meal> {
    private ArrayList<Meal> meals;

    public MealsManager() {
        this.meals = new ArrayList<>();
        this.addMeal("No Meal", 0, 0, false);
    }

    /**
     * Return a Meal object if the meal is present in this.meals
     * @param name take in the name of a meal
     * @return the meal if the meal is present in the menu
     */
    public Meal getMeal(String name) {

        for (Meal m : this.meals) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Check if a meal is available or not
     * @param mealName to accept the name of a meal from the user
     * @return a boolean value representing whether a meal is available or not
     */
    public boolean checkForMeal(String mealName) {

        for (Meal m: this.meals) {
            if (m.getName().equals(mealName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A function allowing us to add meals to our meal list which can then be ordered by the passengers
     * @param name input the name of a meal
     * @param calories input the calories associated with the meal
     * @param price input the price associated with the meal
     * @param isVeg input a boolean value to see if a meal is Vegetarian or not
     */
    public void addMeal(String name, double calories, double price, boolean isVeg) {

        this.meals.add(new Meal(name, calories, price, isVeg));
    }

    @Override
    public Iterator<Meal> iterator() {
        return new GeneralIterator<Meal>(this.meals);
    }
}
