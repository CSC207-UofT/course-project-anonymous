package UseCases.factories;

import Entites.Users.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerFactory {
    public Map<String, String> getPassengerInfo(Passenger passenger) {
        Map<String, String> info = new HashMap<>();

        info.put("name", passenger.getName());
        info.put("email", passenger.getEmail());
        info.put("number", passenger.getNumber());
        info.put("points", "" + passenger.getPoints());
        info.put("id", "" + passenger.getId());
        info.put("membership", "" + passenger.getMembership().getMembershipName());

        return info;
    }
}
