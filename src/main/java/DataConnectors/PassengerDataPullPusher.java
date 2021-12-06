package DataConnectors;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Map;

public class PassengerDataPullPusher implements DataPullPusher {

    String tableName = "users";

    @Override
    public ArrayList<Map<String, String>> loadData() {
        return DataPullPusher.loadData(tableName, "ORDER BY \"password\"");
    }

    @Override
    public void addEntity(Map<String, String> entityFields) {
        String values = "('" + entityFields.get("name") +
                "', '" + entityFields.get("email") +
                "', '" + entityFields.get("number") +
                "', '" + entityFields.get("id") +
                "', '" + 0 + "');";

        databaseConnector.runQuery("INSERT INTO " + databaseConnector.getTableName(tableName) +
                "(\"name\", \"email\", \"number\", \"password\", \"points\") VALUES " + values);
    }

    @Override
    public void removeEntity(Map<String, String> entityFields) {
        // not required for passengers currently
    }

    public void updatePoints(int passenger_id, int points) {
        databaseConnector.runQuery("UPDATE " + databaseConnector.getTableName(tableName) +
                "SET \"points\"='" + points + "' WHERE \"password\"='" + passenger_id + "';");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Map<String, String> passengerData = (Map<String, String>) evt.getNewValue();
        this.updatePoints(Integer.parseInt(passengerData.get("id")), Integer.parseInt(passengerData.get("points")));
    }
}
