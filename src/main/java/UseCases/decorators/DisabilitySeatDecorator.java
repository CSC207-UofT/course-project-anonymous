package UseCases.decorators;

import Entites.*;

public class DisabilitySeatDecorator extends SeatDecorator{

    static int disabilityBaggageAllowance = 1;

    public DisabilitySeatDecorator(Seat decoratedSeat) {
        super(decoratedSeat);
    }

    @Override
    public int numberOfCabinBagsAllowed() {
        return decoratedSeat.numberOfCabinBagsAllowed() + disabilityBaggageAllowance;
    }
}
