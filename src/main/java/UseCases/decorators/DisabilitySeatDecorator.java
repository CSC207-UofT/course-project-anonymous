package UseCases.decorators;
import Entites.*;

public class DisabilitySeatDecorator extends SeatDecorator{
    static int disabilityBaggageAllowance = 1;

    /**
     * Construct a DisabilitySeatDecorator, giving it the given
     * Seat object.
     *
     * @param decoratedSeat A seat object
     */
    public DisabilitySeatDecorator(Seat decoratedSeat) {
        super(decoratedSeat);
    }

    /**
     * @return the number of cabin bags allowed for a disabled person
     */
    @Override
    public int numberOfCabinBagsAllowed() {
        return decoratedSeat.numberOfCabinBagsAllowed() + disabilityBaggageAllowance;
    }

    /**
     * @return the number of check in bags allowed for a disabled person
     */
    public int numberOfCheckInBagsAllowed(){
        return decoratedSeat.numberOfCheckInBagsAllowed() + disabilityBaggageAllowance;
    }
}
