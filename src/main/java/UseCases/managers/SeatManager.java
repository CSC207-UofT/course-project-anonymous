package UseCases.managers;

import Entites.*;

import java.util.ArrayList;

public class SeatManager {
    Seat seat;

    /**
     * Construct a SeatManager, giving it the given
     * seat object
     *
     * @param seat A seat object
     */
    public SeatManager(Seat seat) {
        this.seat = seat;
    }

    /**
     * Calculate the refund price for a given Seat based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     * @param departureDate the departure date of the flight
     *
     * @return the refunded price of the Seat
     */
    public double calculateRefundByDaysLeft(int daysLeft, int departureDate) {
        // full refund if refund asked before 7 days of the flight
        if (daysLeft >= 7) {
            return this.seat.getPrice();
        } else if (daysLeft >= 1) {
            // partial refund is provided if refund is asked before 1 day of the flight
            // and the refund decreases as you get closer to departure date
            return this.seat.getPrice() -
                    (this.seat.getPrice() * (departureDate - daysLeft) * 0.01);
        } else {
            // no refund is provided if asked for refund the day of the flight
            return 0;
        }
    }

    /**
     * Calculate the charge for changing the date of departure based
     * on how many days are left until departure date
     *
     * @param daysLeft how many days are left until the departure date
     * @param departureDate the departure date of the flight
     *
     * @return the charge price of making this change
     */
    public double calculateDateChangeChargeByDateLeft(int daysLeft, int departureDate) {
        // no charge if date is changed a week before departure date
        if (daysLeft >= 7) {
            return 0;
        } else {
            // charge increases as you get closer to departure date
            return (this.seat.getPrice() * (departureDate - daysLeft) * 0.01);
        }
    }
}
