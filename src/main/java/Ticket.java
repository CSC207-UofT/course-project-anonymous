import java.util.ArrayList;

public class Ticket {
    // TODO: make all the instance variables private
    Passenger passenger;
    Flight flight;
    Seat seat;
    Meal meal;
    ArrayList<Baggage> baggages; // TODO: implement iterator design pattern

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

    // TODO: Managing bags should not be done in ticket, instead in baggage manager or ticket manager or other use case
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
    private int noOfCabinBags(ArrayList<Baggage> baggages) {
        int count = 0;

        for (Baggage b: baggages) {                                        //-|
            if (b instanceof CabinBaggage) {                               // |
                count++;                                                   // |
            }                                                              // |
        }                                                                  //-|
                                                                           // |
        return count;                                                      // |
    }                                                                      // |
                                                                           // |---- TODO: Same code could be extracted
    private int noOfCheckInBags(ArrayList<Baggage> baggages) {             // |
        int count = 0;                                                     // |
                                                                           // |
        for (Baggage b: baggages) {                                        //-|
            if (b instanceof CheckInBaggage) {                             // |
                count++;                                                   // |
            }                                                              // |
        }                                                                  //-|

        return count;
    }

    @Override
    public String toString() {
        /*
        TODO: could be extracted to a presenter
         */
        String header = "******************************************Ticket******************************************\n";

        String passengerInfo = this.passenger.getName();

        String flightName = "Flight Name: " + flight.airline.name + "-" + flight.getId() + "\n";
        String fromTo = "From: " + flight.from + "       To: " + flight.to + "\n";
        String departureLanding = "Departure Date & Time: " + flight.departureTime.toString()
                + "    Landing Date & Time: " + flight.landingTime.toString() + "\n";

        String seatString = this.seat.getSeatClass() + " Seat     Seat No. " + flight.seats.indexOf(seat);

        String bags = "No of Cabin Bags: " + this.noOfCabinBags(this.baggages) +
                "   no of CheckIn Bags: " + noOfCheckInBags(this.baggages);

        String mealSelected = "Meal selected: " + meal.getName();

        String spacer = " \n";

        return header + spacer + passengerInfo + spacer + spacer + flightName + spacer + fromTo + spacer +
                departureLanding + spacer +spacer + seatString + spacer + spacer + bags + spacer + spacer +
                mealSelected + spacer + spacer + header;
    }
}
