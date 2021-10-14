import java.util.ArrayList;

public class MealsManager {
    ArrayList<Meal> meals;

    public MealsManager() {
        this.meals = new ArrayList<>();

        this.addMeal("Sushi", 2.3, 3, false);
        this.addMeal("Margarita", 5.2, 2, true);
        // TODO: Add Meals or load them from a dataset
    }

    public Meal getMeal(String name) {
        for (Meal m : this.meals) {
            if (m.getName() == name) {
                return m;
            }
        }
        return null;
    }

    public void addMeal(String name, double calories, double price, boolean isVeg) {
        this.meals.add(new Meal(name, calories, price, isVeg));
    }
}
