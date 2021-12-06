package Entites;

import Entites.Baggages.Baggage;
import Entites.Seats.Seat;
import Entites.Users.Passenger;

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
     * Returns a passenger object from the ticket
     *
     * @return returns the passenger on the ticket
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Returns the flight object from the ticket
     *
     * @return returns the flight on the ticket
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Returns the seat object on the ticket
     *
     * @return returns the seat on the ticket
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Sets a seat object to the ticket
     *
     * @return void. Sets seat to the given seat object
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * Gets the meal object on the ticket
     *
     * @return returns the meal on the ticket
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * Sets a meal object to the ticket
     *
     * @return void. Sets meal to the given meal object
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * Gets the baggage objects on the ticket
     *
     * @return returns the baggage on the ticket
     */
    public ArrayList<Baggage> getBaggages() {
        return baggages;
    }

    /**
     * Sets baggage objects to the ticket
     *
     * @return void. Sets baggage to the given baggage object
     */
    public void setBaggages(ArrayList<Baggage> baggages) {
        this.baggages = baggages;
    }
}
