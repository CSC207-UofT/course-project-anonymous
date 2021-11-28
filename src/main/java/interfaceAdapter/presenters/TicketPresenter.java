package interfaceAdapter.presenters;

import Entites.Ticket;
import UseCases.managers.BaggageManager;

import java.util.ArrayList;

public class TicketPresenter {
    public String presentTicket(Ticket ticket) {
        BaggageManager baggageManager = new BaggageManager();

        String header = "\n******************************************Ticket******************************************\n";

        String passengerInfo = ticket.getPassenger().getName();

        String flightName = "Flight Name: " + ticket.getFlight().getAirline().name + "-" + ticket.getFlight().getId() + "\n";
        String fromTo = "From: " + ticket.getFlight().getFrom() + "       To: " + ticket.getFlight().getTo() + "\n";
        String departureLanding = "Departure Date & Time: " + ticket.getFlight().getDepartureTime().toString()
                + "    Landing Date & Time: " + ticket.getFlight().getLandingTime().toString() + "\n";

        String seatString = ticket.getSeat().getSeatClass() + " Seat     Seat No. " + ticket.getFlight().getSeatNo(ticket.getSeat());

        String bags = "No of Cabin Bags: " + baggageManager.noOfCabinBags(ticket.getBaggages()) +
                "   no of CheckIn Bags: " + baggageManager.noOfCheckInBags(ticket.getBaggages());

        String mealSelected = "Meal selected: " + ticket.getMeal().getName();

        String spacer = " \n";

        return header + spacer + passengerInfo + spacer + spacer + flightName + spacer + fromTo + spacer +
                departureLanding + spacer +spacer + seatString + spacer + spacer + bags + spacer + spacer +
                mealSelected + spacer + spacer + header;
    }

    public String presentTickets(ArrayList<Ticket> tickets) {
        String string_so_far = "";

        for (Ticket ticket : tickets) {
            string_so_far += this.presentTicket(ticket);
        }

        return string_so_far;
    }
}
