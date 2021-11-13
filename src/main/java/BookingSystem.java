import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingSystem {

     PassengerManager passengerManager;
     AirlinesManager airlinesManager;
     TransactionManager transactionManager;
     MealsManager mealsManager;
     RescheduleManager rescheduleManager;
     TicketManager ticketManager;

    public BookingSystem() {
        this.passengerManager = new PassengerManager();
        this.airlinesManager = new AirlinesManager();
        this.transactionManager = new TransactionManager();
        this.mealsManager = new MealsManager();
        this.rescheduleManager = new RescheduleManager();
        this.ticketManager = new TicketManager();

        this.ticketManager.addObserver(this.passengerManager);
        this.addRandomData();
    }

    public void addRandomData() {
        this.airlinesManager.addAirline("Emirates");
        this.airlinesManager.addAirline("Air India");
        this.airlinesManager.addAirline("Air France");
        this.airlinesManager.addAirline("Air Canada");
        this.airlinesManager.addAirline("Qatar");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.airlinesManager.getAirline("Emirates").addFlight(LocalDateTime.parse("2021-08-22 08:22", formatter),
                                                                    LocalDateTime.parse("2021-08-22 11:24", formatter),
                                                                    "London", "Dubai", 2000);

        this.airlinesManager.getAirline("Qatar").addFlight(LocalDateTime.parse("2021-08-22 01:23", formatter),
                                                                 LocalDateTime.parse("2021-08-22 08:22", formatter),
                                                                 "London", "Dubai", 2000);

        this.airlinesManager.getAirline("Air India").addFlight(LocalDateTime.parse("2021-09-22 08:22", formatter),
                LocalDateTime.parse("2021-09-22 11:24",formatter),
                "Delhi", "Toronto", 3000);

        this.airlinesManager.getAirline("Air Canada").addFlight(LocalDateTime.parse("2021-08-22 01:25", formatter),
                LocalDateTime.parse("2021-08-22 08:22", formatter),
                "Delhi", "Toronto", 3000);

        this.mealsManager.addMeal("Sushi", 2.3, 3, false);
        this.mealsManager.addMeal("Margarita", 5.2, 2, true);
    }


}
