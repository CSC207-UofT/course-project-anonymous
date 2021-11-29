package UseCases.managers;

public class MembershipManager {
    /**
     * calculates the time for how long a user can access the lounge
     * based on how many membership points they have
     *
     * @param points a user's membership points
     *
     * @return how many hours the user can access the lounge
     **/
    public int calculateLoungeAccess(int points) {
        // each point equals 3 minutes of accessing the lounge
        return (points * 3) / 60;
    }

    /**
     * calculates how many points will be used based on how
     * many hours the user wants to stay in the lounge
     *
     * @param hours the amount of time the user stays at a lounge
     *
     * @return how many points will be deducted based on their stay
     **/
    public int calculatePointsForLoungeHours(int hours) {
        return (hours * 60) / 3;
    }
}
