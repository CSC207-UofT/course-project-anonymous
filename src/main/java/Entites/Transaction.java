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


    public double calculateTotal() {
         double total = 0;

         for (Double price: this.items.values()) {
             total += price;
         }

         return ((float)Math.round(total * 100) / 100);
    }

    public HashMap<String, Double> getItems() {
        return this.items;
    }
}
