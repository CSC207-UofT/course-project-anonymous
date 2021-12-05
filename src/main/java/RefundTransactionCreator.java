import java.time.Duration;
import java.time.LocalDate;

public class RefundTransactionCreator {
    /**
     * creates a new Transaction in the case wehre the passenger requests to cancel or change bookings
     * @param ticket The passengers Ticket
     * @return The transaction with information regarding the refund
     */

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

    /**
     * gets the diference between 2 dates
     * @param d1 date 1
     * @param d2 date 2
     * @return the difference in the number of days between the 2 dates
     */
    long getDifferenceDays(LocalDate d1, LocalDate d2) {
        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}
