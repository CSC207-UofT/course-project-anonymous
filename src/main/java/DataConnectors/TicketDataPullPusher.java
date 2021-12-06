package DataConnectors;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Map;

public class TicketDataPullPusher implements DataPullPusher {

    String tableName = "tickets";

    @Override
    public ArrayList<Map<String, String>> loadData() {
        return DataPullPusher.loadData(tableName);
    }

    @Override
    public void addEntity(Map<String, String> entityFields) {
        String values = "('" + entityFields.get("flightName") +
                "', '" + entityFields.get("seatNo") +
                "', '" + entityFields.get("passengerId")+
                "', '" + entityFields.get("mealName") +
                "', '" + entityFields.get("noOfCabinBags") +
                "', '" + entityFields.get("noOfCheckInBags") + "');";

        String columns = "(\"flightname\", \"seatid\", \"passengerid\", \"mealname\", \"cabinbaggages\", \"checkinbaggages\")";
        String query = "INSERT INTO " + databaseConnector.getTableName(tableName) + " " + columns + " VALUES " + values;

        databaseConnector.runQuery(query);
    }

    @Override
    public void removeEntity(Map<String, String> entityFields) {
        String condition1 = "\"flightname\"='" + entityFields.get("flightName") + "'";
        String condition2 = "\"seatid\"='"+ entityFields.get("seatNo") + "'";
        String condition3 = "\"passengerid\"='" + entityFields.get("passengerId") + "'";

        String query = "DELETE FROM " + databaseConnector.getTableName(tableName) + "WHERE (" + condition1 + " AND " + condition2 + " AND " + condition3 + ");";

        databaseConnector.runQuery(query);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getOldValue() != null) {
            this.addEntity((Map<String, String>) evt.getOldValue());
        }
    }
}
