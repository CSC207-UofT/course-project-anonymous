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
        this.passengers.add(new Passenger(this.currentIdCount, name, email, number));
        int idToReturn = this.currentIdCount;
        this.currentIdCount++;
        return idToReturn;
    }

    public void addPassenger(String name, String email, String number, int id) {
        this.passengers.add(new Passenger(id, name, email, number));
        int idToReturn = this.currentIdCount;
        this.currentIdCount = id + 1;
    }

    public Passenger getPassengerWithId(int id) {
        int index = getIndex(id);

        if (index == -1) {
            return null;
        }
        return this.passengers.get(index);
    }

    public boolean removePassengerWithId(int id) {
        int index = getIndex(id);

        if (index == -1) {
            return false;
        }
        this.passengers.remove(index);
        return true;
    }

    private int getIndex(int id) {
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
}

