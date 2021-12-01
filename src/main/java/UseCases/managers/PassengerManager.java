package UseCases.managers;

import Entites.Passenger;
import UseCases.factories.MembershipFactory;
import UseCases.GeneralIterator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

public class PassengerManager implements Iterable<Passenger>, PropertyChangeListener {
    static int[] pointsThreshold = {0, 1000, 10000, 100000};

    private int currentIdCount = 0;
    ArrayList<Passenger> passengers;

    public PassengerManager() {
        this.passengers = new ArrayList<>();
    }

    public int addPassenger(String name, String email, String number) {
        /**
         * Add a passanger to the system without points.
         * @param name input the name of the passanger
         * @param email input the email of the passanger
         * @param number input the phone number of the passanger
         * @return the passanger ID
         */
        this.passengers.add(new Passenger(this.currentIdCount, name, email, number));
        int idToReturn = this.currentIdCount;
        this.currentIdCount++;
        return idToReturn;
    }

    public void addPassenger(String name, String email, String number, int id, int points) {
        /**
         * Add a passanger to the system with points.
         * @param name input the name of the passanger
         * @param email input the email of the passanger
         * @param number input the phone number of the passanger
         * @param points add the given number of points to the given passanger's account
         */
        Passenger passenger = new Passenger(id, name, email, number);
        passenger.setPoints(points);
        this.upgradeMembership(passenger, PassengerManager.pointsThreshold);
        this.passengers.add(passenger);
        this.currentIdCount = id + 1;
    }

    public Passenger getPassengerWithId(int id) {
        /**
         * Retrieve the details of a passanger with a given id
         * @param id input the id of a passanger
         * @return the passanger details to the corresponding id
         */
        int index = getIndex(id);

        if (index == -1) {
            return null;
        }
        return this.passengers.get(index);
    }

    public boolean removePassengerWithId(int id) {
        /**
         * Remove the details of a passanger with the given id
         * @param id input the id of a passanger
         * @return if the corresponding passanger has been removed from the system
         */
        int index = getIndex(id);

        if (index == -1) {
            return false;
        }
        this.passengers.remove(index);
        return true;
    }

    private int getIndex(int id) {
        /**
         * Get the index at which a particular passanger is stored
         * @param id input the id of a passanger
         * @return the index at which the passanger is present in the list
         */
        int index = -1;

        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void upgradeMembership(Passenger passenger, int[] pointsThreshold) {
        new MembershipFactory().setMembership(passenger, pointsThreshold);
    }

    @Override
    public Iterator<Passenger> iterator() {
        return new GeneralIterator<Passenger>(this.passengers);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.upgradeMembership(((Passenger) evt.getNewValue()), PassengerManager.pointsThreshold);
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }
}

