package UseCases.decorators;

import Entites.*;

public abstract class SeatDecorator implements SeatBaggageAllowance{
    protected Seat decoratedSeat;

    public SeatDecorator(Seat decoratedSeat){
        this.decoratedSeat = decoratedSeat;
    }

    public int numberOfCabinBagsAllowed(){
        return decoratedSeat.numberOfCabinBagsAllowed();
    }

    public int numberOfCheckInBagsAllowed(){
        return decoratedSeat.numberOfCheckInBagsAllowed();
    }
}
