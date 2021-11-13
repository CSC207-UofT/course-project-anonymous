import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TestRescheduleManager {
    RescheduleManager rescheduleManager;

    @Before
    public void initializeRManager() {
        rescheduleManager = new RescheduleManager();
        ticketManager = new TicketManager();
        ticketManager.addTicket(ticket.getPassenger(), flight, newSeat, ticket.getMeal(), ticket.getBaggages());
    }
    @Test
    public void testReschedule() {
        int seatIndex = ticket.getFLight().getSeatNo(oldSeat);
        assert(newSeat = flight.getSeatAtIndex(seatIndex));

    }

}
