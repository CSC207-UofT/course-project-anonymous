package interfaceAdapter.presenters;

import Entites.Seat;

import java.util.ArrayList;

public class SeatMapPresenter {
    public String presentSeats(ArrayList<Boolean> seats) {
        /*
        Prints out the seat map for the given seats array
         */

        String starting_string = "  0 1 2 3 4 5 6 7 8\n \n";

        for (int i = 0; i < seats.size(); i+=9) {
            String seatsRowString = "";
            for (int j = i; j < i+9; j++) {
                seatsRowString += this.getSymbol(seats.get(j)) + " ";
            }
            starting_string +=  (int) Math.floor(i/9) + " " + seatsRowString + "\n";
        }

        return starting_string;
    }

    String getSymbol(Boolean isOccupied) {
        if (isOccupied) {return "x";} else {return "o";}
    }
}
