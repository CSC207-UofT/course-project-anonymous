package interfaceAdapter.presenters;

import Entites.Ticket;
import UseCases.managers.BaggageManager;

import java.util.ArrayList;
import java.util.Map;

public class TicketPresenter {
    public String presentTicket(Map<String, String> ticketInfo) {

        String header = "\n******************************************Ticket******************************************\n";

        String passengerInfo = ticketInfo.get("passengerName");

        String flightName = "Flight Name: " + ticketInfo.get("airlineName") + "-" + ticketInfo.get("flightId") + "\n";
        String fromTo = "From: " + ticketInfo.get("flightFrom") + "       To: " + ticketInfo.get("flightTo") + "\n";
        String departureLanding = "Departure Date & Time: " + ticketInfo.get("flightDepartureTime")
                + "    Landing Date & Time: " + ticketInfo.get("flightLandingTime") + "\n";

        String seatString = ticketInfo.get("seatClass") + " Seat     Seat No. " + ticketInfo.get("seatNo");

        String bags = "No of Cabin Bags: " + ticketInfo.get("noOfCabinBags") +
                "   no of CheckIn Bags: " + ticketInfo.get("noOfCheckInBags");

        String mealSelected = "Meal selected: " + ticketInfo.get("mealName");

        String spacer = " \n";

        return header + spacer + passengerInfo + spacer + spacer + flightName + spacer + fromTo + spacer +
                departureLanding + spacer +spacer + seatString + spacer + spacer + bags + spacer + spacer +
                mealSelected + spacer + spacer + header;
    }

    public String presentTickets(ArrayList<Map<String, String>> ticketsInfo) {
        String string_so_far = "";

        for (Map<String, String> ticket : ticketsInfo) {
            string_so_far += this.presentTicket(ticket);
        }

        return string_so_far;
    }
}
