package Entites;
import java.util.HashMap;

public class Transaction {
    /**
     * Transaction that has calculates the price of the ticket
     */
    HashMap<String, Double> items;

    public Transaction() {
        items = new HashMap<>();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
    }

    /**
     * Calculates a total amount in dollars for the ticket cost
     *
     * @return returns a double containing the price of the ticket
     */
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
