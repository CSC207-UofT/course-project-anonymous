package UseCases.managers;

import Entites.*;
import Entites.Baggages.Baggage;
import Entites.Memberships.Seats.Seat;
import Entites.Users.Passenger;
import UseCases.GeneralIterator;
import UseCases.factories.PassengerFactory;
import UseCases.factories.TicketFactory;
import UseCases.helpers.TicketFilter;

import java.util.ArrayList;
import java.util.Iterator;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.Map;

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
  
    public Map<String, String> addTicket(Passenger passenger, Flight flight, Seat seat, Meal meal, ArrayList<Baggage> baggages, boolean loadingData) {
        TicketFactory ticketFactory = new TicketFactory();
        PassengerFactory passengerFactory = new PassengerFactory();


        Ticket ticket = new Ticket(passenger, flight, seat, loadingData);
        ticket.setMeal(meal); ticket.setBaggages(baggages);

        if (!loadingData) {
            observable.firePropertyChange("points added", ticketFactory.getTicketInfo(ticket), passengerFactory.getPassengerInfo(passenger));
        } else {
            observable.firePropertyChange("points added", null, passengerFactory.getPassengerInfo(passenger));
        }
        this.tickets.add(ticket);
        return ticketFactory.getTicketInfo(ticket);
    }

    /**
     * Remove a ticket from the system
     * @param input the ticket which needs to be removed from the system
     */
    public void removeTicket(Ticket ticket) {

        PassengerFactory passengerFactory = new PassengerFactory();
        Map<String, String> passengerInfo = passengerFactory.getPassengerInfo(ticket.getPassenger());

        ticket.getSeat().setOccupied(false);
        ticket.getPassenger().setPoints(Math.toIntExact(ticket.getPassenger().getPoints() - Math.round(ticket.getFlight().getMiles() / 100)));
        observable.firePropertyChange("points added", null, passengerInfo);
        this.tickets.remove(ticket);
    }

    public Ticket getTicketFromInfo(Map<String, String> ticketInfo) {
        TicketFilter ticketFilter = new TicketFilter();
        return ticketFilter.getTicketWithInfo(this, ticketInfo);
    }

    @Override
    public Iterator<Ticket> iterator() {
        return new GeneralIterator<Ticket>(this.tickets);
    }

    public ArrayList<Ticket> getTickets() {return this.tickets;}
}
