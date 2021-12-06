package UseCases.helpers;

import Entites.*;
import Entites.Baggages.Baggage;
import Entites.Memberships.Seats.Seat;
import Entites.Users.Passenger;
import UseCases.managers.BaggageManager;

import java.util.ArrayList;

public class NewTicketTransactionCreator {
    /**
     * Creates the transaction for each new ticket purchased
     * @param passenger a passenger object
     * @param seat the seat the passenger chose to book
     * @param meal the meal preference of the passenger
     * @param baggages the baggage preference of the passenger
     * @return returns a transaction object capturing all the necessary information
     */
    public Transaction getTransaction(Passenger passenger,
                                      Seat seat,
                                      Meal meal,
                                      ArrayList<Baggage> baggages) {

        BaggageManager baggageManager = new BaggageManager();

        Transaction transaction = new Transaction();

        transaction.addItem("Seat Charge", seat.getPrice());
        transaction.addItem("Meal Charge", meal.getPrice());
        transaction.addItem("Baggage Charge", baggageManager.calculateTotalPrice(seat, baggages));
        transaction.addItem("Membership Flight Discount",
                -passenger.getMembership().getFlightDiscount(seat.getPrice()));
        transaction.addItem("Membership Meal Discount",
                -passenger.getMembership().getMealDiscount(meal.getPrice()));
        transaction.addItem("Membership Baggage Discount",
                -passenger.getMembership().getExtraBaggageDiscount(baggageManager.calculateTotalPrice(seat, baggages)));

        return transaction;
    }
}
