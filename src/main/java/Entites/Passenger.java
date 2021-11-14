package Entites;

import java.util.*;

public class Passenger extends User {

    private int points;
    private MembershipStatus membership;
    
    public Passenger(int id, String name, String email, String number) {
        super(id, name, email, number);
        this.membership = new Standard();
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
