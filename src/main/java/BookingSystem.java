import java.time.LocalDate;
import java.util.*;

public class BookingSystem {

     PassengerManager passengerManager;
     AgentsManager agentsManager;
     AirlinesManager airlinesManager;
     TransactionManager transactionManager;
     MealsManager mealsManager;
     RescheduleManager rescheduleManager;

    public BookingSystem() {
        this.passengerManager = new PassengerManager();
        this.airlinesManager = new AirlinesManager();
        this.transactionManager = new TransactionManager();
        this.mealsManager = new MealsManager();
        this.rescheduleManager = new RescheduleManager();
        this.agentsManager = new AgentsManager();
    }
}
