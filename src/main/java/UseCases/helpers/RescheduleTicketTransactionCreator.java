package UseCases.helpers;

import Entites.Flight;
import Entites.Seats.Seat;
import Entites.Ticket;
import Entites.Transaction;

import java.time.Duration;
import java.time.LocalDate;


public class RescheduleTicketTransactionCreator {
    /**
     * Creates a new transaction for recheduling a flight
     * @param oldTicket Passengers current ticked which they would like changed
     * @param newFlight The new flight to which they would like to change
     * @return The new Transaction object
     */
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
