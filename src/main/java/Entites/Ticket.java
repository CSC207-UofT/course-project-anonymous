package Entites;

import java.util.ArrayList;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    private Meal meal;
    private ArrayList<Baggage> baggages;

    /**
     * Constructs a ticket, giving it the given passenger, flight, seat, loadingData
     * @param passenger passenger object on ticket
     * @param flight the flight the ticket belongs to
     * @param seat the passengers' assigned seat
     * @param loadingData false will set points to the passenger
     */
    public Ticket(Passenger passenger, Flight flight, Seat seat, boolean loadingData) {
        this.passenger = passenger; this.flight = flight; this.seat = seat;
        if (!loadingData) {
            this.passenger.setPoints(Math.toIntExact(this.passenger.getPoints() + Math.round(flight.getMiles() / 100)));
        }
        seat.setOccupied(true);
    }

    /**
     *
     * @return returns the passenger on the ticket
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     *
     * @return returns the flight on the ticket
     */
    public Flight getFlight() {
        return flight;
    }
    /**
     *
     * @return returns the seat on the ticket
     */
    public Seat getSeat() {
        return seat;
    }
    /**
     *
     * @return void. Sets seat to the given seat object
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    /**
     *
     * @return returns the meal on the ticket
     */
    public Meal getMeal() {
        return meal;
    }
    /**
     *
     * @return void. Sets meal to the given meal object
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    /**
     *
     * @return returns the baggage on the ticket
     */
    public ArrayList<Baggage> getBaggages() {
        return baggages;
    }
    /**
     *
     * @return void. Sets baggage to the given baggage object
     */
    public void setBaggages(ArrayList<Baggage> baggages) {
        this.baggages = baggages;
    }
}
