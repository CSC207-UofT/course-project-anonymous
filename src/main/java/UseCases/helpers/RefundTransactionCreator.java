package UseCases.helpers;

import Entites.Ticket;
import Entites.Transaction;
import UseCases.managers.BaggageManager;

import java.time.Duration;
import java.time.LocalDate;

public class RefundTransactionCreator {
    public Transaction getTransaction(Ticket ticket) {
        Transaction transaction = new Transaction();
        BaggageManager baggageManager = new BaggageManager();
        RefundAndRescheduleSeatPriceCalculator refundAndRescheduleSeatPriceCalculator = new RefundAndRescheduleSeatPriceCalculator();

        long daysLeft = this.getDifferenceDays(ticket.getFlight().getDepartureTime().toLocalDate(), LocalDate.now());

        transaction.addItem("Seat price (you get back) : ", ticket.getSeat().getPrice());
        transaction.addItem("Baggage price (you get back) : ", baggageManager.calculateTotalPrice(ticket.getSeat(), ticket.getBaggages()));
        transaction.addItem("Meal price (you get back) : ", ticket.getMeal().getPrice());
        transaction.addItem("Refund Cost Deducted : ",
                -refundAndRescheduleSeatPriceCalculator.calculateRefundByDaysLeft(ticket.getSeat(), ((int) daysLeft)));

        return transaction;
    }

    long getDifferenceDays(LocalDate d1, LocalDate d2) {
        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}
