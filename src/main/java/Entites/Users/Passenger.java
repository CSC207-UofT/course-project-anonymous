package Entites.Users;

import Entites.Memberships.MembershipStatus;
import Entites.Memberships.Standard;

public class Passenger extends User {

    private int points;
    private MembershipStatus membership;

    /**
     *  Constructs a passenger with the given id, name, email, and phone number
     *
     * @param id the id of the passenger
     * @param name name of the passenger
     * @param email email of the passenger
     * @param number phone number of the passenger
     */

    public Passenger(int id, String name, String email, String number) {
        super(id, name, email, number);
        this.membership = new Standard();
    }

    // GETTERS AND SETTERS:

    /**
     * Gets a passengers membership
     *
     * @return returns a membership object
     */
    public MembershipStatus getMembership() {
        return membership;
    }

    /**
     * Sets a membership object to the passenger
     *
     * @param membership sets a passengers' membership status to a membership object
     */
    public void setMembership(MembershipStatus membership) {
        this.membership = membership;
    }

    /**
     * Gets the amount of points a passenger has
     *
     * @return returns the points assigned to the passenger
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets an integer value of points to the passenger
     *
     * @param points set points to an integer value
     */
    public void setPoints(int points) {
        this.points = points;
    }
}
