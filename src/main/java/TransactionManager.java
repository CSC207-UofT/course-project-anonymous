import java.util.ArrayList;
import java.util.Iterator;

public class TransactionManager implements Iterable<Transaction> {
    private ArrayList<Transaction> transactions;
    private NewTicketTransactionCreator newTicketTransactionCreator;
    private RescheduleTicketTransactionCreator rescheduleTicketTransactionCreator;
    private RefundTransactionCreator refundTransactionCreator;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
        this.newTicketTransactionCreator = new NewTicketTransactionCreator();
        this.rescheduleTicketTransactionCreator = new RescheduleTicketTransactionCreator();
        this.refundTransactionCreator = new RefundTransactionCreator();
    }

    public Transaction createTransactionForNewTicket(Passenger passenger,
                                                     Seat seat,
                                                     Meal meal,
                                                     ArrayList<Baggage> baggages) {
        Transaction transaction = this.newTicketTransactionCreator.getTransaction(passenger, seat, meal, baggages);
        this.addTransaction(transaction);
        return transaction;
    }

    public Transaction createTransactionRescheduleTicket(Ticket ticket, Flight flight) {
        Transaction transaction = new RescheduleTicketTransactionCreator().getTransaction(ticket, flight);
        return transaction;
    }

    public Transaction createTransactionRefundTicket(Ticket ticket) {
        Transaction transaction = this.refundTransactionCreator.getTransaction(ticket);
        this.transactions.add(transaction);
        return transaction;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void remove(Transaction transaction) {
        for(Transaction t : transactions) {
            if (t == transaction) {
                this.transactions.remove(t);
            }
        }
    }

    @Override
    public Iterator<Transaction> iterator() {
        return new GeneralIterator<Transaction>(this.transactions);
    }
}
