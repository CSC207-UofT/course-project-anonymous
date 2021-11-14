package UseCases.MementoTicketStages;
import java.util.ArrayList;

public class Caretaker {
    private ArrayList<SeatPresenterMemento> seatChartList = new ArrayList<SeatPresenterMemento>();

    public void addMemento (SeatPresenterMemento m) {

        seatChartList.add(m);
        System.out.println("Seating Plans Maintained:" + seatChartList);
    }

    public SeatPresenterMemento getMemento(int index) {

        return seatChartList.get(index);
    }

}
