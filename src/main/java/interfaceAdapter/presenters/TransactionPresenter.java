package interfaceAdapter.presenters;

import Entites.Transaction;

public class TransactionPresenter {
    public String presentTransaction(Transaction transaction) {
        String header = "***********************Transaction***********************\n";

        String billSoFar = "";

        for (String key : transaction.getItems().keySet()) {
            billSoFar += key + " : " + transaction.getItems().get(key) + "\n";
        }

        String totalBillBeforeAfter = "********************************************************* \n";
        String totalBill = "Total : " + transaction.calculateTotal();

        return header + " \n" + billSoFar
                + totalBillBeforeAfter + totalBill + "\n" + totalBillBeforeAfter;
    }
}
