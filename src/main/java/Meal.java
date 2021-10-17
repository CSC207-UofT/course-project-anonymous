public class Meal {
    private String name; private boolean vegitarian;
    private double calories; private double price;

    public Meal(String name, double calories, double price, boolean vegitarian) {
        this.name = name; this.vegitarian = vegitarian;
        this.calories = calories; this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public boolean isVegitarian() {
        return vegitarian;
    }
}