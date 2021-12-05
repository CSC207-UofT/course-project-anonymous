public class RandomMealsGenerator {
    MealsManager mealsManager;

    RandomMealsGenerator(MealsManager mealsManager) {
        this.mealsManager = mealsManager;
    }

    public void generateData() {
        this.mealsManager.addMeal("Pizza", 100, 11.30, true);
        this.mealsManager.addMeal("Pasta", 100, 9.30, true);
        this.mealsManager.addMeal("Rice", 100, 5.30, true);
        this.mealsManager.addMeal("Cake", 100, 11.00, true);
        this.mealsManager.addMeal("Noodles", 100, 12.30, true);
        this.mealsManager.addMeal("Chicken", 100, 15.30, false);
        this.mealsManager.addMeal("Fish", 100, 15.30, false);
        this.mealsManager.addMeal("Eggs", 100, 13.30, false);
        this.mealsManager.addMeal("Sausage", 100, 18.30, true);
        this.mealsManager.addMeal("tuna", 100, 20.30, false);
        this.mealsManager.addMeal("Burger", 100, 10.30, true);
        this.mealsManager.addMeal("Beagle", 100, 5.30, true);
        this.mealsManager.addMeal("Burrito", 100, 11.30, true);
    }

    public void init() {
        this.generateData();
    }
}