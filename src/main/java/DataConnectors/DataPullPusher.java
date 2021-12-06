package DataConnectors;

import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DataPullPusher extends PropertyChangeListener {

    public ArrayList<Map<String, String>> loadData();

    public void addEntity(Map<String, String> entityFields);
    public void removeEntity(Map<String, String> entityFields);

    static DatabaseConnector databaseConnector = new DatabaseConnector();

    public static ArrayList<Map<String, String>> loadData(String tableName) {
        String query = "SELECT * FROM " +  databaseConnector.getTableName(tableName) + ";";
        return DataPullPusher.getResultSetData(databaseConnector.runQuery(query));
    };

    public static ArrayList<Map<String, String>> loadData(String tableName, String OrderBy) {
        String query = "SELECT * FROM " +  databaseConnector.getTableName(tableName) + " " + OrderBy + ";";
        return DataPullPusher.getResultSetData(databaseConnector.runQuery(query));
    };

    public static ArrayList<Map<String, String>> getResultSetData(ResultSet resultSet) {
        ArrayList<Map<String, String>> data = new ArrayList<>();

        try {
            while (resultSet.next()) {
                HashMap<String, String> row = new HashMap<>();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    row.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        } catch (Exception exception) {
            return null;
        }
    }
}
