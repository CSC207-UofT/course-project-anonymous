package interfaceAdapter.controller;

import Entites.Passenger;
import UseCases.managers.PassengerManager;
import interfaceAdapter.controller.DataHandler;
import interfaceAdapter.controller.DatabaseConnector;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;

public class PassengerDataHandler extends DataHandler implements PropertyChangeListener {

    public PassengerDataHandler(DatabaseConnector databaseConnector) {
        super(databaseConnector, "users");
    }

    public void fetchPassengersIntoApp(PassengerManager passengerManager) {
        ArrayList<Map<String, String>> data = this.loadData("ORDER BY \"password\"");

        for (Map<String, String> row : data) {
            passengerManager.addPassenger(row.get("name"), row.get("email"), row.get("number"), Integer.parseInt(row.get("password")), Integer.parseInt(row.get("points")));
        }
    }

    public void addPassenger(String name, String email, String number, String password) {
        String values = "('" + name +
                "', '" + email +
                "', '" + number +
                "', '" + password +
                "', '" + 0 + "');";

        databaseConnector.runQuery("INSERT INTO " + databaseConnector.getTableName(tableName) +
                "(\"name\", \"email\", \"number\", \"password\", \"points\") VALUES " + values);
    }

    public void updatePoints(int passenger_id, int points) {
        databaseConnector.runQuery("UPDATE " + databaseConnector.getTableName(tableName) +
                "SET \"points\"='" + points + "' WHERE \"password\"='" + passenger_id + "';");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Passenger passenger = (Passenger) evt.getNewValue();
        this.updatePoints(passenger.getId(), passenger.getPoints());
    }
}
