public class meal {

    private String name;
    private int calories;
    private int cost;
    private boolean isVeg;

    public meal(String name, int calories, int cost, boolean isVeg);
    this.name =name;
    this.calories =calories;
    this.cost =cost;
    this.isVeg =isVeg;


    public boolean getVeg() {

        return this.isVeg;
    }


    public String getName() {
        return this.name;
    }

    public int getCalories() {

        return this.calories;
    }

    public int getCost() {

        return this.cost;
    }

}
