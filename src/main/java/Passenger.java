import java.util.*;

public class Passenger extends User {

    private int points;
    private MembershipStatus membership;
    
    public Passenger(int id, String name, String email, String number) {
        super(id, name, email, number);

        this.membership = new Standard();
    }

    public void upgradeMembership(int[] pointsThreshold) {
        /*
        According to current points upgrade the membership.

        @param pointsThreshold: list of point thresholds, for different memberships.

        Ex. if pointsThreshold = [0, 100, 200, 300],  then:
        - if you have 0 <= points < 100 then you have standard membership.
        - if you have 100 <= points < 200 then you have Silver membership.
        - if you have 200 <= points < 300 then you have Gold membership.
        - if you have 300 <= points then you have Platinum membership.

        TODO: This function should maybe be moved to a use case class, as this class should only store data
         */

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
