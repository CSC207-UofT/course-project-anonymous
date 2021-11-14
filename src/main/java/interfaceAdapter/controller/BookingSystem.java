package interfaceAdapter.controller;

import UseCases.managers.*;
import interfaceAdapter.*;

public class BookingSystem {

     public PassengerManager passengerManager;
     public AirlinesManager airlinesManager;
     public TransactionManager transactionManager;
     public MealsManager mealsManager;
     public RescheduleManager rescheduleManager;
     public TicketManager ticketManager;

     public RandomFlightsGenerator randomFlightsGenerator;
     public RandomMealsGenerator randomMealsGenerator;

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
