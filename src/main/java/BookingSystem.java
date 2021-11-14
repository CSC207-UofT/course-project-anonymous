import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingSystem {

     PassengerManager passengerManager;
     AirlinesManager airlinesManager;
     TransactionManager transactionManager;
     MealsManager mealsManager;
     RescheduleManager rescheduleManager;
     TicketManager ticketManager;

     RandomFlightsGenerator randomFlightsGenerator;
     RandomMealsGenerator randomMealsGenerator;

    public BookingSystem() {
        this.passengerManager = new PassengerManager();
        this.airlinesManager = new AirlinesManager();
        this.transactionManager = new TransactionManager();
        this.mealsManager = new MealsManager();
        this.rescheduleManager = new RescheduleManager();

        this.ticketManager = new TicketManager();

        this.ticketManager.addObserver(this.passengerManager);

        randomFlightsGenerator = new RandomFlightsGenerator(this.airlinesManager, "2021-11-13");
        randomFlightsGenerator.init();

        randomMealsGenerator = new RandomMealsGenerator(this.mealsManager);
        randomMealsGenerator.init();
    }
}
