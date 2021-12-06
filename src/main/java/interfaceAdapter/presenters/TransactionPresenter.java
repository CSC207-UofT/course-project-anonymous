package interfaceAdapter.presenters;

import Entites.Transaction;

import java.util.Map;

public class TransactionPresenter {
    public String presentTransaction(Map<String, Double> transaction) {
        String header = "***********************Transaction***********************\n";

        String billSoFar = "";
        double totalSoFar = 0.0;

        for (String key : transaction.keySet()) {
            billSoFar += key + " : " + transaction.get(key) + "\n";
            totalSoFar += transaction.get(key);
        }

        String totalBillBeforeAfter = "********************************************************* \n";
        String totalBill = "Total : " + totalSoFar;

        return header + " \n" + billSoFar
                + totalBillBeforeAfter + totalBill + "\n" + totalBillBeforeAfter;
    }
}
