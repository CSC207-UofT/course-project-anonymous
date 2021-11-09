import MementoTicketStages.SeatOriginator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CmdUI {
    private PassengerSessionHandler passengerSessionHandler;
    private AgentSessionHandler agentSessionHandler;

    public static void main(String[] args) {
        CmdUI cmdUI = new CmdUI();
        Scanner scanner = new Scanner(System.in);
        cmdUI.start(scanner, false);
    }

    public void start(Scanner scanner, boolean askingAgain) {
        /*

         */
        if (!askingAgain) {
            System.out.println("Hi Welcome to Anonymous Flight Reservation System \n ");
        }

        System.out.println("Who Are You : \n \n 1. User \n 2. Agent \n \n Type 1 or 2 : ");

        String userInp = scanner.nextLine();

        if (userInp.equals("1")) {
            this.passengerSessionHandler = new PassengerSessionHandler();
            this.signInUpPassenger(scanner, false); /* Takes the user to the passenger sign up page*/
        }
        else if (userInp.equals("2")) {
            this.agentSessionHandler = new AgentSessionHandler();
            this.signInUpAgent(scanner, false);
        }
        else {
            System.out.println("You can only choose from 1 or 2. \n ");
            this.start(scanner, true);
        }
    }

    public void signInUpPassenger(Scanner scanner, boolean askingAgain) {
        /*
        Asks the passenger for their personal details
         */
        System.out.println("Hi there! are you new to our app? Sign up, If not Sign In. \n \n");

        System.out.println("1. Sing Up \n 2.Sign In \n \n Type 1 or 2 : ");

        String userInp = scanner.nextLine();

        if (userInp.equals("1")) {
            this.signUpPassenger(scanner, false);
        }
        else if (userInp.equals("2")) {
            this.signInPassenger(scanner, false);
        }
        else {
            System.out.println("You can only choose from 1 or 2. \n ");
            this.start(scanner, true);
        }
    }


    public void signUpPassenger(Scanner scanner, boolean askAgain) {
        /*
        Adds a new passenger to the PassengerManager class with the details they provided
         */
        if (!askAgain) {
            System.out.print("Please fill out your personal details to create an account \n");
        }

        System.out.println("Your Name : ");
        String name = scanner.nextLine();

        System.out.println("email : ");
        String email = scanner.nextLine();

        System.out.println("number : ");
        String number = scanner.nextLine();

        System.out.println("Are you satisfied with your answers \n \n 1. Yes \n 2. No \n \n Type 1 or 2 :  ");
        String userInp = scanner.nextLine();

        if (userInp.equals("1")) {
            int id = this.passengerSessionHandler.bookingSystem.passengerManager.addPassenger(name, email, number);

            System.out.println("Congrats! You are now a member, your ID is " + id + ". This would be used to SignIn. \n");
            this.signInPassenger(scanner, false);
        }
        else if (userInp.equals("2")) {
            this.signUpPassenger(scanner, true);
        }
        else {
            System.out.println("You can only choose from 1 or 2. \n ");
            this.signUpPassenger(scanner, false);
        }
    }

    public void signInPassenger(Scanner scanner, boolean askAgain) {
        /*
        If the passenger has a pre-existing ID, it will allow the passenger to directly sign in.
        The passenger will be retrieved from the array of passengers based on their unique ID
         */
        if (!askAgain) {
            System.out.println("Please fill in your id to sign in \n");
        }

        System.out.println("Your SignIn ID : \n");
        int id = Integer.parseInt(scanner.nextLine());

        if (this.passengerSessionHandler.setSessionUserWithId(id)) {
            this.menu(scanner);
        } else {
            System.out.println("There is no user with id: " + id + ". Please try again. \n");
            this.signInPassenger(scanner, true);
        }
    }

    public void menu(Scanner scanner) {
        /*
        Displays the possible options the passenger can choose to continue using the app.
         */
        System.out.println("What would you like to do today "
                + this.passengerSessionHandler.passenger.getName() +  "\n \n ");

        System.out.println("1. Search & Book Flight \n 2. Booking History \n 3. End App Use \n \n Type 1, 2 or 3 : ");

        String userInp = scanner.nextLine();

        if (userInp.equals("1")) {
            this.flightSearchFilter(scanner, false);
        }
        else if (userInp.equals("2")) {
            System.out.println("Sorry this feature has not been implemented :-( \n");
            this.menu(scanner);
        }
        else if (userInp.equals("3")) {
            System.out.println("Thankyou for Using Anonymous Airplane Reservation System \n");
        }
        else {
            System.out.println("You can only choose from 1, 2 or 3. \n ");
            this.menu(scanner);
        }
    }

    public void flightSearchFilter(Scanner scanner, boolean askAgain) {
        /*
        Takes in information regarding the To and From destinations along with the dates and uses it
        to display available flights from the database
         */
        System.out.println("Please fill in the filter form below : \n \n");

        System.out.println("From : ");
        String from = scanner.nextLine();

        System.out.println("to : ");
        String to = scanner.nextLine();

        System.out.println("Date (yyyy-mm-dd) : ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        ArrayList<Flight> flights = this.passengerSessionHandler.bookingSystem.
                airlinesManager.getFlightsByFilter(from, to, date);

        if (flights.size() > 0) {
            System.out.println(FlightsPresenter.presentFlights(flights));
            this.whatToDoWithFlights(scanner, flights);
        } else {
            System.out.println("No flights were found for " + date + ", going from " + from + " to " + to + "\n");
            this.menu(scanner);
        }
    }

    public void whatToDoWithFlights(Scanner scanner, ArrayList<Flight> flights) {
        System.out.println("\n 1. Choose a flight to book \n 2. Back to Menu \n Type 1 or 2 : " );
        String userInp = scanner.nextLine();


        if (userInp.equals("1")) {
            System.out.println("Type the name of the flight (ex. Emirates-111) : ");
            String flightName = scanner.nextLine();

            this.startBookingProcessForFlight(scanner, this.passengerSessionHandler.bookingSystem.
                    airlinesManager.getFlightByName(flightName));
        }
        else if (userInp.equals("2")) {
           this.menu(scanner);
        }
        else {
            System.out.println("You can only choose from 1 or 2. \n");
            this.whatToDoWithFlights(scanner, flights);
        }
    }

    public void startBookingProcessForFlight(Scanner scanner, Flight flight) {
        ArrayList<Seat> seats = flight.getSeatsOfClass(this.askSeatClassQuestion(scanner));
        String seatsMap = FlightsPresenter.presentSeats(seats);

        System.out.println("Select a Seat: \n");
        System.out.println(seatsMap + "\n \n");
        new SeatOriginator(seatsMap).setSeatmap(seatsMap);

        Seat seat = this.selectSeatQuestion(scanner, seats);
        ArrayList<Baggage> baggages = this.addBaggageQuestion(scanner, new ArrayList<Baggage>());
        Meal meal = this.askMealQuestion(scanner);

        Transaction transaction = this.passengerSessionHandler.bookingSystem.transactionManager.
                createTransactionForNewTicket(this.passengerSessionHandler.passenger, seat, meal, baggages);

        System.out.println(transaction.toString() + "\n");

        if (this.askTransactionQuestion(scanner).equals("1")) {
            Ticket ticket = this.passengerSessionHandler.bookingSystem.ticketManager
                    .addTicket(this.passengerSessionHandler.passenger, flight, seat, meal, baggages);

            System.out.println("Your ticket has been booked. Congrats! \n");

            System.out.println(ticket.toString());

            this.menu(scanner);
        } else {
            this.menu(scanner);
        }
    }

    public String askTransactionQuestion(Scanner scanner) {
        System.out.println("Do you want to pay and book your ticket \n \n1. Yes i'll pay and book the ticket " +
                "\n2. No, go back to the menu");

        String userInp = scanner.nextLine();

        if (!userInp.equals("1") && !userInp.equals("2")) {
            System.out.println("You can only select from 1 or 2. \n");
            return askTransactionQuestion(scanner);
        }
        return userInp;
    }

    public Meal askMealQuestion(Scanner scanner) {
        System.out.println("Choose a meal: \n");

        for (Meal m: this.passengerSessionHandler.bookingSystem.mealsManager.meals) {
            System.out.println(m.getName());
        }

        System.out.println("\n Type the name of the meal :");
        String mealName = scanner.nextLine();

        if (this.passengerSessionHandler.bookingSystem.mealsManager.checkForMeal(mealName)) {
            return this.passengerSessionHandler.bookingSystem.mealsManager.getMeal(mealName);
        } else {
            System.out.println("You can only select from above meals\n");
            return askMealQuestion(scanner);
        }
    }

    public ArrayList<Baggage> addBaggageQuestion(Scanner scanner, ArrayList<Baggage> baggagesSoFar) {

        System.out.println("Do you want to add any baggage \n \n");

        System.out.println("1. Add a cabin bag \n2. Add a checkin bag \n3. Continue to Meal selection \n");
        String userInp = scanner.nextLine();

        if (userInp.equals("1")) {
            System.out.println("write the weight of the cabin baggage :" );
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("write the height of the cabin baggage :" );
            double height = Double.parseDouble(scanner.nextLine());
            System.out.println("write the width of the cabin baggage :" );
            double width = Double.parseDouble(scanner.nextLine());

            baggagesSoFar.add(new CabinBaggage(weight, width, height));
            System.out.println("Cabin bag of height: " + height + ", width: " + width +
                    ", weight: " + weight + " has been added \n");

            return this.addBaggageQuestion(scanner, baggagesSoFar);

        } else if (userInp.equals("2")) {

            System.out.println("write the weight of the checkin baggage :" );
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("write the height of the checkin baggage :" );
            double height = Double.parseDouble(scanner.nextLine());
            System.out.println("write the width of the checkin baggage :" );
            double width = Double.parseDouble(scanner.nextLine());

            baggagesSoFar.add(new CheckInBaggage(weight, width, height));
            System.out.println("CheckIn bag of height: " + height + ", width: " + width +
                    ", weight: " + weight + " has been added \n");

            return this.addBaggageQuestion(scanner, baggagesSoFar);

        } else if (userInp.equals("3")) {
            return baggagesSoFar;
        } else {
            System.out.println("You can only type one of 1, 2, or 3 \n");
            return this.addBaggageQuestion(scanner, baggagesSoFar);
        }

    }

    public String askSeatClassQuestion(Scanner scanner) {
        System.out.println("\nLets book this flight for you! \n \n What Class do you want to book \n \n" +
                "1. Economy \n 2. Business \n 3. First \n  \n Type 1, 2 or 3 : ");

        String seatClass = scanner.nextLine();

        if (!seatClass.equals("1") && !seatClass.equals("2") && !seatClass.equals("3")) {
            System.out.println("You can only choose from 1, 2, or 3");
            return this.askSeatClassQuestion(scanner);
        }
        return seatClass;
    }

    public Seat selectSeatQuestion(Scanner scanner, ArrayList<Seat> seats) {
        System.out.println("Select row : ");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Select column : ");
        int col = Integer.parseInt(scanner.nextLine());

        int index = (row * 9) + col;

        if (index >= seats.size()) {
            System.out.println("Please type in valid row and column \n");
            return this.selectSeatQuestion(scanner, seats);
        } else {
            return seats.get(index);
        }
    }



    public void signInUpAgent(Scanner scanner, boolean askingAgain) {
        System.out.println("Agent UI is still under construction. Sorry :-(");
    }
}
