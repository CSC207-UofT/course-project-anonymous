import java.util.ArrayList;

public class MementoCaretaker {

    private List<Memento> seatChartList = new ArrayList<Memento>();

    public void addMemento (Memento m) {

        seatChartList.add(m);
        System.out.println("Seating Plans Maintained:" + seatChartList );

    public Memento getMemento (int index) {

        return seatChartList.get(index);
        }



    }
}
