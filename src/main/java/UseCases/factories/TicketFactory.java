package UseCases.factories;

import Entites.Ticket;
import UseCases.managers.BaggageManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicketFactory {
    public Map<String, String> getTicketInfo(Ticket ticket) {
        BaggageManager baggageManager = new BaggageManager();

        HashMap<String, String> ticketInfo = new HashMap<>();

        ticketInfo.put("passengerName", ticket.getPassenger().getName());
        ticketInfo.put("airlineName", ticket.getFlight().getAirline().name);
        ticketInfo.put("flightId", "" + ticket.getFlight().getId());
        ticketInfo.put("flightFrom", ticket.getFlight().getFrom());
        ticketInfo.put("flightTo", ticket.getFlight().getTo());
        ticketInfo.put("flightDepartureTime", ticket.getFlight().getDepartureTime().toString());
        ticketInfo.put("flightLandingTime", ticket.getFlight().getLandingTime().toString());
        ticketInfo.put("seatClass", ticket.getSeat().getSeatClass());
        ticketInfo.put("seatNo", "" + ticket.getFlight().getSeatNo(ticket.getSeat()));
        ticketInfo.put("noOfCabinBags", "" + baggageManager.noOfCabinBags(ticket.getBaggages()));
        ticketInfo.put("noOfCheckInBags", "" + baggageManager.noOfCheckInBags(ticket.getBaggages()));
        ticketInfo.put("mealName", ticket.getMeal().getName());
        ticketInfo.put("flightName", ticket.getFlight().getAirline().name + "-" + ticket.getFlight().getId());

        return ticketInfo;
    }

    public ArrayList<Map<String, String>> getTicketsInfo(ArrayList<Ticket> tickets) {
        ArrayList<Map<String, String>> ticketsInfo = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketsInfo.add(this.getTicketInfo(ticket));
        }

        return ticketsInfo;
    }
}
