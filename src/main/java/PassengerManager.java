import java.util.*;

public class PassengerManager {
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

    public Passenger getPassengerWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }
        return this.passengers.get(index);
    }

    public boolean removePassengerWithId(int id) {
        int index = -1;

        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.passengers.remove(index);
        return true;
    }
}

