public class TransactionPresenter {
    String presentTransaction(Transaction transaction) {
        String header = "***********************Transaction***********************\n";

        String billSoFar = "";

        for (String key : transaction.items.keySet()) {
            billSoFar += key + " : " + transaction.items.get(key) + "\n";
        }

        String totalBillBeforeAfter = "********************************************************* \n";
        String totalBill = "Total : " + transaction.calculateTotal();

        return header + " \n" + billSoFar
                + totalBillBeforeAfter + totalBill + "\n" + totalBillBeforeAfter;
    }
}
