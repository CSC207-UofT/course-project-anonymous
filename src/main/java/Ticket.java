import java.util.ArrayList;

public class Ticket {

    Passenger passenger;
    Flight flight;
    Seat seat;
    Meal meal;
    ArrayList<Baggage> baggages;

    private int currentBaggageId;

    public Ticket(Passenger passenger, Flight flight, Seat seat, Meal meal, ArrayList<Baggage> baggages) {
        this.passenger = passenger; this.flight = flight; this.seat = seat; this.meal = meal; this.baggages = baggages;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void addBag(Baggage b) {
        b.setId(this.currentBaggageId);
        this.currentBaggageId++;
        this.baggages.add(b);
    }

    public boolean removeBag(int id) {
        int index = -1;

        for (int i = 0; i < baggages.size(); i++) {
            if (baggages.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        baggages.remove(index);
        return true;
    }
}
