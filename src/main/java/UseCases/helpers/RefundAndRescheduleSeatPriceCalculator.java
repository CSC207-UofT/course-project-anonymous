package UseCases.helpers;

import Entites.Seat;

public class RefundAndRescheduleSeatPriceCalculator {

    /**
     * Calculate the refund price for a given Seat based
     * on how many days are left until departure date
     *
     * @param seat seat object for which we need to calculate refund
     * @param daysLeft how many days are left until the departure date
     *
     * @return the refunded price of the Seat
     */
    public double calculateRefundByDaysLeft(Seat seat, int daysLeft) {
        // full refund if refund asked before 7 days of the flight
        if (daysLeft >= 7) {
            return seat.getPrice();
        } else if (daysLeft >= 1) {
            // partial refund is provided if refund is asked before 1 day of the flight
            // and the refund decreases as you get closer to departure date
            return seat.getPrice() -
                    (seat.getPrice() *((float)7-daysLeft) * 0.1);
        } else {
            // no refund is provided if asked for refund the day of the flight
            return 0;
        }
    }

    /**
     * Calculate the charge for changing the date of departure based
     * on how many days are left until departure date
     *
     * @param seat seat object for which charge for changing the date needs to be calculated
     * @param daysLeft how many days are left until the departure date
     * @param differenceInDepartureDates difference in the departure dates of the flight before and after
     *
     * @return the charge price of making this change
     */
    public double calculateDateChangeChargeByDateLeft(Seat seat, int daysLeft, int differenceInDepartureDates) {
        // no charge if date is changed a week before departure date
        if (daysLeft >= 7) {
            return 0;
        } else {
            // charge increases as you get closer to departure date
            return (seat.getPrice() * ((float)differenceInDepartureDates / daysLeft) * 0.01);
        }
    }
}
