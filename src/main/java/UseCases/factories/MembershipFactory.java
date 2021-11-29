package UseCases.factories;

import Entites.*;

public class MembershipFactory {

    /**
     * return the desired object of type MembershipStatus
     *
     * @param membershipStatusType the type of membership a user has
     *
     * @return the object of the corresponding type MembershipStatus
     **/
    public MembershipStatus getMembership(String membershipStatusType){
        if(membershipStatusType == null){
            return null;
        }
        if(membershipStatusType.equalsIgnoreCase("STANDARD")){
            return new Standard();

        } else if(membershipStatusType.equalsIgnoreCase("SILVER")){
            return new Silver();

        } else if(membershipStatusType.equalsIgnoreCase("GOLD")){
            return new Gold();

        } else if(membershipStatusType.equalsIgnoreCase("PLATINUM")){
            return new Platinum();
        }

        return null;
    }

    /**
     * Set the membership status of a passenger based on how many points they have
     *
     * @param passenger a passenger object
     * @param pointsThreshold a list of ints containing point thresholds
     *                        for different types of Memberships
     *
     * Ex. if pointsThreshold = [0, 100, 200, 300],  then:
     *         - if you have 0 <= points < 100 then you have standard membership.
     *         - if you have 100 <= points < 200 then you have Silver membership.
     *         - if you have 200 <= points < 300 then you have Gold membership.
     *         - if you have 300 <= points then you have Platinum membership.
     *
     **/
    public void setMembership(Passenger passenger, int[] pointsThreshold) {
        MembershipStatus[] membershipArray = {new Standard(),
                new Silver(),
                new Gold(),
                new Platinum()};

        int currentIndex = 0;

        for (int i = 0; i < pointsThreshold.length; i++) {
            if (pointsThreshold[i] > passenger.getPoints()) {
                break;
            }
            currentIndex = i;
        }

        passenger.setMembership(membershipArray[currentIndex]);
    }
}

