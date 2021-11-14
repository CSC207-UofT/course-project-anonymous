package Entites;

import java.util.ArrayList;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    private Meal meal;
    private ArrayList<Baggage> baggages;

    public Ticket(Passenger passenger, Flight flight, Seat seat, boolean loadingData) {
        this.passenger = passenger; this.flight = flight; this.seat = seat;
        if (!loadingData) {
            this.passenger.setPoints(Math.toIntExact(this.passenger.getPoints() + Math.round(flight.getMiles() / 100)));
        }
        seat.setOccupied(true);
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

    public ArrayList<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(ArrayList<Baggage> baggages) {
        this.baggages = baggages;
    }
}
