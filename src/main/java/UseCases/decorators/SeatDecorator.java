package UseCases.decorators;
import Entites.Seats.Seat;
import Entites.Seats.SeatBaggageAllowance;

public abstract class SeatDecorator implements SeatBaggageAllowance {
    protected Seat decoratedSeat;

    /**
     * Construct a SeatDecorator, giving it the given
     * Seat object.
     *
     * @param decoratedSeat A seat object
     */
    public SeatDecorator(Seat decoratedSeat){
        this.decoratedSeat = decoratedSeat;
    }

    /**
     * @return the number of cabin bags allowed
     */
    public int numberOfCabinBagsAllowed(){
        return decoratedSeat.numberOfCabinBagsAllowed();
    }

    /**
     * @return the number of check in bags allowed
     */
    public int numberOfCheckInBagsAllowed(){
        return decoratedSeat.numberOfCheckInBagsAllowed();
    }
}
