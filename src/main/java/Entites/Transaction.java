package Entites;
import java.util.HashMap;

public class Transaction {
    HashMap<String, Double> items;

    public Transaction() {
        items = new HashMap<>();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
    }

    public HashMap<String, Double> getItems() {
        return this.items;
    }
}
