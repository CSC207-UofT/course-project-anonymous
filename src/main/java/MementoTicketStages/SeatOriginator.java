package MementoTicketStages;

public class SeatOriginator {
    private String seatmap;

    public SeatOriginator(String seats){
        this.seatmap = seats;
    }
    public String getSeatmap(){return this.seatmap;}

    public SeatOriginator setSeatmap(String seats){
        this.seatmap = seats;
        return this;
    }

    public SeatPresenterMemento createMemento(){
        return new SeatPresenterMemento(seatmap);
    }

    public void restore(SeatPresenterMemento memento){
        if (memento != null) {
            this.seatmap = memento.getSeatmap();
        }
        else {
            System.out.println("Can't restore without memento object!");
        }
    }
}
