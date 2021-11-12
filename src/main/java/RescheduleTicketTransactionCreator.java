import java.time.Duration;
import java.time.LocalDate;


public class RescheduleTicketTransactionCreator {
    public Transaction getTransaction(Ticket oldTicket, Flight newFlight) {
        Transaction transaction = new Transaction();
        RefundAndRescheduleSeatPriceCalculator refundAndRescheduleSeatPriceCalculator = new RefundAndRescheduleSeatPriceCalculator();

        Seat oldSeat = oldTicket.getSeat();
        int seatIndex = oldTicket.getFlight().getSeatNo(oldSeat);
        Seat newSeat = newFlight.getSeatAtIndex(seatIndex);

        long daysLeft = this.getDifferenceDays(oldTicket.getFlight().getDepartureTime().toLocalDate(), LocalDate.now());
        long differenceInDepartureDates = this.getDifferenceDays(oldTicket.getFlight().getDepartureTime().toLocalDate(),
                oldTicket.getFlight().getDepartureTime().toLocalDate());

        double reschedulePrice = refundAndRescheduleSeatPriceCalculator.calculateDateChangeChargeByDateLeft(oldSeat,
                ((int )daysLeft), ((int) differenceInDepartureDates));

        transaction.addItem("New seat price: ", newSeat.getPrice());
        transaction.addItem("Old seat price", -oldSeat.getPrice());
        transaction.addItem("Reschedule price", reschedulePrice);

        return transaction;
    }

    long getDifferenceDays(LocalDate d1, LocalDate d2) {
        return Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays();
    }
}
