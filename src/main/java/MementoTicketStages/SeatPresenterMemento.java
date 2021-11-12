package MementoTicketStages;

public class SeatPresenterMemento {
    private String seatmap;

    public SeatPresenterMemento(String seatmap){
        this.seatmap = seatmap;
    }
    public String getSeatmap(){return this.seatmap;}
}
