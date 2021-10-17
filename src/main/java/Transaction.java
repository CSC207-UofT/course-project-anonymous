import java.util.HashMap;

public class Transaction {
    private HashMap<String, Double> items;

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

         return total;
    }


    @Override
    public String toString() {
        String header = "***********************Transaction***********************\n";

        String billSoFar = "";

        for (String key : this.items.keySet()) {
            billSoFar += key + " : " + this.items.get(key) + "\n";
        }

        String totalBillBeforeAfter = "********************************************************* \n";
        String totalBill = "Total : " + this.calculateTotal();

        return header + " \n" + billSoFar
                + totalBillBeforeAfter + totalBill + "\n" + totalBillBeforeAfter;
    }
}
