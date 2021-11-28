package interfaceAdapter.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class DatabaseConnector {

    private String bitUser; private String bitApiKey;
    private String bitDB; private String bitHost; String bitPort;

    Connection connection;
    Properties properties;

    public DatabaseConnector() {
        this.bitUser = "eeshannarula29"; this.bitApiKey = "M672_4Pm9xbyYsGnP7TDgfBJx3Pw";
        this.bitDB = "AirplaneResSys"; this.bitHost = "db.bit.io"; this.bitPort = "5432";

        this.createProperties();
        this.connect();
    }

    public void createProperties() {
        this.properties = new Properties();
        this.properties.setProperty("sslmode","require");
        this.properties.setProperty("user",this.bitUser);
        this.properties.setProperty("password",this.bitApiKey);
    }

    public void connect() {
        try {
            this.connection = DriverManager
                    .getConnection("jdbc:postgresql://" + bitHost + ":" + bitPort + "/" + bitDB, this.properties);
        } catch (SQLException sqlException) {
            System.out.println("The app was not able to connect with the database");
        }
    }

    public ResultSet runQuery(String sql) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(sql);
        } catch (Exception exception) {
            return null;
        }
    }

    public String getTableName(String table) {
        return "\"" + this.bitUser + "/" + this.bitDB + "\".\"" + table + "\"";
    }
}
