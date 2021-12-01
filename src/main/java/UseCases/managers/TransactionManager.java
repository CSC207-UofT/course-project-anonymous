package UseCases.managers;

import Entites.*;

import java.util.ArrayList;
import java.util.Iterator;

import UseCases.helpers.*;
import UseCases.GeneralIterator;

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
        /**
         * To create a new transaction to calculate cost of a ticket for the user
         * @param passanger input the details of the passanger
         * @param seat input the details of the seat chosen by the passanger
         * @param meal input the detalis of the meal preferences of the passanger
         * @param baggages input the number and type of baggages carried by the passanger
         * @return a transaction to calculate the overall cost of the ticket to the passanger
         */
        Transaction transaction = this.newTicketTransactionCreator.getTransaction(passenger, seat, meal, baggages);
        this.addTransaction(transaction);
        return transaction;
    }

    public Transaction createTransactionRescheduleTicket(Ticket ticket, Flight flight) {
        /**
         * Calculate the cost of rescheduling a ticket
         * @param ticket input the old ticket details from the user
         * @param flight input the flight details from the user
         * @return a transaction object for the cost associated with rescheduling a ticket
         */
        Transaction transaction = new RescheduleTicketTransactionCreator().getTransaction(ticket, flight);
        return transaction;
    }

    public Transaction createTransactionRefundTicket(Ticket ticket) {
        /**
         * Create a transaction to refund the cost of a ticket to the user
         * @param ticket input the ticket details
         * @return a transaction object containing the cost of the ticket to be refunded
         */
        Transaction transaction = this.refundTransactionCreator.getTransaction(ticket);
        this.transactions.add(transaction);
        return transaction;
    }

    public void addTransaction(Transaction transaction) {
        /**
         * Add a transaction
         * @param transaction a transaction object
         */
        this.transactions.add(transaction);
    }

    public void remove(Transaction transaction) {
        /**
         * Remove a transaction from the list
         * @param transaction remove a transaction from the list
         */
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
