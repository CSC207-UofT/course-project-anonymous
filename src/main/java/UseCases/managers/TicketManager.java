package UseCases.managers;

import Entites.*;
import UseCases.GeneralIterator;

import java.util.ArrayList;
import java.util.Iterator;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class TicketManager implements Iterable<Ticket> {
    private ArrayList<Ticket> tickets;
    private final PropertyChangeSupport observable;

    public TicketManager() {
        this.tickets = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);
    }

    /**
     * Adding observers to this observable class
     * @param observer is an observer class
     */
    public void addObserver(PropertyChangeListener observer) {

        observable.addPropertyChangeListener("points added", observer);
    }

    /**
     * Add a ticket to the system
     * @param passenger input passenger details
     * @param flight input the filght details
     * @param seat input the seat details
     * @param meal input the meal preferances of the user
     * @param baggages input the baggage details of the user
     * @param loadingData input whether loadingData is applicable or not
     * @return the generated ticket
     */
    public Ticket addTicket(Passenger passenger, Flight flight, Seat seat, Meal meal, ArrayList<Baggage> baggages, boolean loadingData) {

        Ticket ticket = new Ticket(passenger, flight, seat, loadingData);
        ticket.setMeal(meal); ticket.setBaggages(baggages);

        if (!loadingData) {
            observable.firePropertyChange("points added", ticket, passenger);
        } else {
            observable.firePropertyChange("points added", null, passenger);
        }
        this.tickets.add(ticket);
        return ticket;
    }

    /**
     * Remove a ticket from the system
     * @param input the ticket which needs to be removed from the system
     */
    public void removeTicket(Ticket ticket) {

        ticket.getSeat().setOccupied(false);
        ticket.getPassenger().setPoints(Math.toIntExact(ticket.getPassenger().getPoints() - Math.round(ticket.getFlight().getMiles() / 100)));
        observable.firePropertyChange("points added", null, ticket.getPassenger());
        this.tickets.remove(ticket);
    }

    @Override
    public Iterator<Ticket> iterator() {
        return new GeneralIterator<Ticket>(this.tickets);
    }

    public ArrayList<Ticket> getTickets() {return this.tickets;}
}
