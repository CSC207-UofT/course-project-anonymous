package DataConnectors;

import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DataPullPusher extends PropertyChangeListener {
    /**
     *The interface has functions to load, add and remove data form a table in the database
     * It also consists of static functions which help writes queries to load the data.
     */

    /**
     * Function to load the data
     * @return A List of Map containing data of a table
     */
    ArrayList<Map<String, String>> loadData();

    /**
     * Add a row to the table
     * @param entityFields row to add
     */
    void addEntity(Map<String, String> entityFields);

    /**
     * remove a row to the table
     * @param entityFields row to remove
     */
    void removeEntity(Map<String, String> entityFields);

    DatabaseConnector databaseConnector = new DatabaseConnector();

    /**
     * Queries the database and load data from a table
     * @param tableName name of the table to get of
     * @return List of Map containing data of the table
     */
    static ArrayList<Map<String, String>> loadData(String tableName) {
        String query = "SELECT * FROM " +  databaseConnector.getTableName(tableName) + ";";
        return DataPullPusher.getResultSetData(databaseConnector.runQuery(query));
    };

    /**
     * Queries the database and load data from a table but with an orderBy argument
     * @param tableName name of the table to get of
     * @return List of Map containing data of the table
     */
    static ArrayList<Map<String, String>> loadData(String tableName, String OrderBy) {
        String query = "SELECT * FROM " +  databaseConnector.getTableName(tableName) + " " + OrderBy + ";";
        return DataPullPusher.getResultSetData(databaseConnector.runQuery(query));
    };

    /**
     * Helper function to format the data loaded from the query
     * @param resultSet the data from the query
     */
    static ArrayList<Map<String, String>> getResultSetData(ResultSet resultSet) {
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
