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

    public void addObserver(PropertyChangeListener observer) {
        observable.addPropertyChangeListener("points added", observer);
    }

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
}
