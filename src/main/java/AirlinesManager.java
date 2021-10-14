import java.util.ArrayList;

public class AirlinesManager {
    ArrayList<Airline> airlines;

    public AirlinesManager() {
        this.airlines = new ArrayList<>();
    }

    public Airline getAirline(String name) {
        int index = -1;

        for (int i = 0; i < this.airlines.size(); i++) {
            if (this.airlines.get(i).name == name) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }
        return this.airlines.get(index);
    }

    public void addAirline(String name) {
        this.airlines.add(new Airline(name));
    }

    public boolean removeAirline(String name) {
        int index = -1;

        for (int i = 0; i < this.airlines.size(); i++) {
            if (this.airlines.get(i).name == name) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        this.airlines.remove(index);
        return false;
    }
}
