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

    DatabaseConnector() {
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



    public static void main(String args[]) {
        Connection c = null;
        String bitApiKey = "M672_4Pm9xbyYsGnP7TDgfBJx3Pw";
        String bitDB = "AirplaneResSys";
        String bitUser = "eeshannarula29";
        String bitHost = "db.bit.io";
        String bitPort = "5432"; // We keep this as a string here as we are concact'ing it into the connection string
        Properties props = new Properties();
        props.setProperty("sslmode","require");
        props.setProperty("user",bitUser);
        props.setProperty("password",bitApiKey);
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://" + bitHost + ":" + bitPort + "/" + bitDB, props);
            Statement stmt = c.createStatement();
            ResultSet is = stmt.executeQuery("INSERT INTO \"eeshannarula29/AirplaneResSys\".\"users\" (\"name\", \"email\", \"number\", \"password\") VALUES ('avnish', 'avishpasari@gmail.com', '6475105023', '1');" );
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"eeshannarula29/AirplaneResSys\".\"users\";" );
            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                // The ResultSet .getXXX() methods expect the column index to start at 1.
                // No idea why.
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.print(rsmd.getColumnName(i) + "="+ rs.getString(i) + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
