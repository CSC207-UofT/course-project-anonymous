import java.util.*;

public class Passenger extends User {


    private int currentBaggageId;
    private ArrayList<Baggage> baggages;

    private int points;
    private MembershipStatus membership;
    
    public Passenger(int id, String name, String email, int number) {
        super(id, name, email, number);

        this.baggages = new ArrayList<>();
        this.currentBaggageId = 0;

        this.membership = new Standard();
    }

    public void addBag(Baggage b) {
        b.setId(this.currentBaggageId);
        this.currentBaggageId++;
        this.baggages.add(b);
    }

    public boolean removeBag(int id) {
        int index = -1;

        for (int i = 0; i < baggages.size(); i++) {
            if (baggages.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        baggages.remove(index);
        return true;
    }

    public void upgradeMembership(int[] pointsThreshold) {

        MembershipStatus[] membershipArray = {new Standard(),
                                              new Silver(),
                                              new Gold(),
                                              new Platinum()};

        int currentIndex = 0;

        for (int i = 0; i < pointsThreshold.length; i++) {
            if (pointsThreshold[i] > this.points) {
                break;
            }
            currentIndex = i;
        }

        this.membership = membershipArray[currentIndex];
    }

    // GETTERS AND SETTERS:

    public MembershipStatus getMembership() {
        return membership;
    }

    public void setMembership(MembershipStatus membership) {
        this.membership = membership;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
