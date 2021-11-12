import java.util.ArrayList;

public class NewTicketTransactionCreator {
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
