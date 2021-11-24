package interfaceAdapter.controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class DataHandler {
    String tableName;
    DatabaseConnector databaseConnector;

    DataHandler(DatabaseConnector databaseConnector, String tableName) {
        this.databaseConnector = databaseConnector;
        this.tableName = tableName;
    }

    public ArrayList<Map<String, String>> loadData() {
        String query = "SELECT * FROM " +  this.databaseConnector.getTableName(this.tableName) + ";";
        return DataHandler.getResultSetData(databaseConnector.runQuery(query));
    };

    public ArrayList<Map<String, String>> loadData(String OrderBy) {
        String query = "SELECT * FROM " +  this.databaseConnector.getTableName(this.tableName) + " " + OrderBy + ";";
        return DataHandler.getResultSetData(databaseConnector.runQuery(query));
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
