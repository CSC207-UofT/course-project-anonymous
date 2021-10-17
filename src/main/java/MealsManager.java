import java.util.ArrayList;

public class MealsManager {
    ArrayList<Meal> meals;

    public MealsManager() {
        this.meals = new ArrayList<>();
        this.addMeal("No Meal", 0, 0, false);
    }

    public Meal getMeal(String name) {
        for (Meal m : this.meals) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public boolean checkForMeal(String mealName) {
        for (Meal m: this.meals) {
            if (m.getName().equals(mealName)) {
                return true;
            }
        }
        return false;
    }

    public void addMeal(String name, double calories, double price, boolean isVeg) {
        this.meals.add(new Meal(name, calories, price, isVeg));
    }
}
