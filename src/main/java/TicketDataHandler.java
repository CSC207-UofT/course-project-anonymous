import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;

public class TicketDataHandler extends DataHandler implements PropertyChangeListener {
    TicketDataHandler(DatabaseConnector databaseConnector) {
        super(databaseConnector, "tickets");
    }

    public void fetchTicketsIntoApp(BookingSystem bookingSystem) {
        ArrayList<Map<String, String>> data = this.loadData();

        for (Map<String, String> row : data) {
            Passenger passenger = bookingSystem.passengerManager.getPassengerWithId(Integer.parseInt(row.get("passengerid")));
            Meal meal = bookingSystem.mealsManager.getMeal(row.get("mealname"));
            Flight flight = bookingSystem.airlinesManager.getFlightByName(row.get("flightname"));
            Seat seat = flight.getSeatAtIndex(Integer.parseInt(row.get("seatid")));
            ArrayList<Baggage> baggages = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(row.get("cabinbaggages")); i++) {
                baggages.add(new CabinBaggage(6, 7, 7));
            }

            for (int i = 0; i < Integer.parseInt(row.get("checkinbaggages")); i++) {
                baggages.add(new CheckInBaggage(20, 23, 23));
            }

            bookingSystem.ticketManager.addTicket(passenger, flight, seat, meal, baggages, true);
        }
    }

    public void addTicket(Ticket ticket) {
        BaggageManager baggageManager = new BaggageManager();

        String flightName = ticket.getFlight().getAirline().name + "-" + ticket.getFlight().getId();
        String values = "('" + flightName +
                "', '" + ticket.getSeat().getId() +
                "', '" + ticket.getPassenger().getId() +
                "', '" + ticket.getMeal().getName() +
                "', '" + baggageManager.noOfCabinBags(ticket.getBaggages()) +
                "', '" + baggageManager.noOfCheckInBags(ticket.getBaggages()) + "');";

        String columns = "(\"flightname\", \"seatid\", \"passengerid\", \"mealname\", \"cabinbaggages\", \"checkinbaggages\")";
        String query = "INSERT INTO " + databaseConnector.getTableName(tableName) + " " + columns + " VALUES " + values;

        databaseConnector.runQuery(query);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getOldValue() != null) {
            this.addTicket((Ticket) evt.getOldValue());
        }
    }

    public void removeTicket(Ticket ticket) {
        String flightName = ticket.getFlight().getAirline().name + "-" + ticket.getFlight().getId();

        String condition1 = "\"flightname\"='" + flightName + "'";
        String condition2 = "\"seatid\"='"+ ticket.getSeat().getId() + "'";
        String condition3 = "\"passengerid\"='" + ticket.getPassenger().getId() + "'";

        String query = "DELETE FROM " + databaseConnector.getTableName(tableName) + "WHERE (" + condition1 + " AND " + condition2 + " AND " + condition3 + ");";

        databaseConnector.runQuery(query);
    }
}
