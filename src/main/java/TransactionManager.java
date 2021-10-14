import java.util.ArrayList;

public class TransactionManager {
    ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public Transaction createTransactionForNewTicket(Passenger passenger,
                                                     Seat seat,
                                                     Meal meal,
                                                     ArrayList<Baggage> baggages) {
        Transaction transaction = new Transaction();
        // TODO: improve item addition in createTransactionForNewTicket
        transaction.addItem("Seat Charge", seat.getPrice());
        transaction.addItem("Meal Charge", meal.getPrice());
        transaction.addItem("Baggage Charge", BaggageManager.calculateTotalPrice(seat, baggages));
        transaction.addItem("Membership Flight Discount",
                -passenger.getMembership().getFlightDiscount(seat.getPrice()));
        transaction.addItem("Membership Meal Discount",
                -passenger.getMembership().getMealDiscount(meal.getPrice()));
        transaction.addItem("Membership Baggage Discount",
                -passenger.getMembership().getExtraBaggageDiscount(BaggageManager.calculateTotalPrice(seat, baggages)));

        this.transactions.add(transaction);
        return transaction;
    }

    public Transaction createTransactionRescheduleTicket() {
        Transaction transaction = new Transaction();
        // TODO: implement createTransactionRescheduleTicket in TransactionManager
        return transaction;
    }
}
