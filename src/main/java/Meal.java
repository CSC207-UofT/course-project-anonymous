public class Meal {
    String name; boolean vegitarian;
    double calories; double price;

    public Meal(String name, double calories, double price, boolean vegitarian) {
        this.name = name; this.vegitarian = vegitarian;
        this.calories = calories; this.price = price;
    }
}
