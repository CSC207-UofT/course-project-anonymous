import java.util.ArrayList;
import java.util.Iterator;

public class MealsManager implements Iterable<Meal> {
    private ArrayList<Meal> meals;

    public MealsManager() {
        this.meals = new ArrayList<>();
        this.addMeal("No Meal", 0, 0, false);
    }

    public Meal getMeal(String name) {
        /*
        Return a Meal object if the meal is present in this.meals

         */
        for (Meal m : this.meals) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public boolean checkForMeal(String mealName) {
        /*
        Return a boolean value representing whether a meal is available or not

         */
        for (Meal m: this.meals) {
            if (m.getName().equals(mealName)) {
                return true;
            }
        }
        return false;
    }

    public void addMeal(String name, double calories, double price, boolean isVeg) {
        /*
        A function allowing us to add meals to our meal list which can then be ordered by the passengers

         */
        this.meals.add(new Meal(name, calories, price, isVeg));
    }

    @Override
    public Iterator<Meal> iterator() {
        return new GeneralIterator<Meal>(this.meals);
    }
}
