## Progress Specification Summary
Our program is based on the domain of an Airline Ticket Reservation system.
The program should be able to sign-in/up different users and agents. 
The users should be able to book/cancel/reschedule a ticket based on their
travel dates and destination. The users should be able to provide their seat
preferences, meal preferences and baggage data. The system should apply any 
discounts the user may be eligible for based on the user’s membership status 
and generate the ticket. The system must be able to generate a list of available 
flights based on what the user’s choices. The system must also allow agents to
maintain a list of clients and manage/book/cancel and reschedule tickets on
behalf of their clients.  

## CRC summary

### Entities

- User (parent class for passenger and agent)
- MembershipStatus (Subclasses: Standard, Sliver, Gold, and Platinum)
- Seat (Subclasses: EconomySeat, BusinessClassSeat, FirstClassSeat)
- Flight 
- Airline
- Meal
- Baggage (Subclass: CabinBaggage, and CheckInBaggage)
- Ticket
- Transaction

### UseCase

- TicketManager
- PassengerManager
- AgentManager
- AirlinesManager
- MealsManager
- BaggageManager
- RescheduleManager

### Controller, GateWay & Presenter

- BookingSystem
- UserSessionHandler (Subclass: PassengerSessionHandler, and AgentSessionHandler)
- FlightPresenter

### UI

- CmdUI


## Scenario Walkthrough Summary

- The user runs the CmdUI file and is prompted to sign-up/in.


- After signing in, the user proceeds to book a flight.


- The user enters their arrival/departure destination and travel dates and gets back a list of available flights.


- The user proceeds to book a flight and select their seat preferences.


- The user is now prompted to enter their baggage information or proceed directly to meal selection (if they don’t have any baggage).


- The user directly proceeds to meal selection and enters their preference.


- A ticket is generated and after the user pays for the ticket, a final ticket is displayed on the command line.


- Finally, the program returns to the main menu.

## Skeleton Program Summary

- CmdUI: UI class that takes input from user ask controller classes to handle the input


- UserSessionHandler: Handles the inputs from the UI, to do all the backend stuff. 


- BookingSystem: Handles all the UseCases, to create new users, book ticket, reschedule ticket and much more. 


- FlightPresenter: Used to print flight information to the command line


- PassengerManager: Used to store all the passengers in the app and the corresponding methods


- AgentManager: Used to store all the Agents in the app and the corresponding methods


- MealsManager: Used to store all the Meals in the app and the corresponding methods


- TicketManager: Used to create a ticket for a passenger when the flight is booked


- TransactionManager: Calculates & Creates transactions for new bookings, rescheduled bookings and refund.


- BaggageManager: Used to calculate cost of baggages for a booking


- User: An abstract class containing information of a user


- Passenger: Subclass of User, that contains user information, points, membership status and corresponding functions.


- MembershipStatus: An abstract class representing a membership which has functions to give discount and lounge access.


- Standard, Silver, Gold, Platinum: subclasses of MembershipStatus. They override functions in MembershipStatus.


- Flight: contain flight information, and collection of Seat objects in the flight with corresponding functions.


- Airline: Contains airline name, collection of Flights, and corresponding function to filter, get and set flights.


- Seat: An abstract class that contains information about number of seat and if it is occupied or not, and corresponding functions.


- Economy, Business, First: Subclasses of seat, which override the price, baggage allowance and refundable status.


- Ticket: class that stores all the information about a booking and related functions.


- Transaction: It is an independent entity, used to add items to a transaction, calculate total and print a receipt.


- Meal: Class to store information about a meal, its name, price, calories and if it is veg or not.

## Questions Group Is Struggling With

One of the major questions the group is struggling with is that how do we store the data. Right now when the application ends,
all the user activity is deleted, and we have no way of retrieving it. We are thinking of ways we can store this data, like 
creating a database locally on our computer with the help of languages like SQL or online on cloud platforms like firebase.
Another question we are trying to solve is how to get and load real world data of flights into our program. Further, we are
looking at where should we use interfaces, and whether we have redundant interfaces in our current model. 

## What has worked well so far with current design:

So far splitting up our program into entities and use cases (by using the SOLID design principles) has worked out well so 
far. This has helped reduce inter-class dependencies and allowed everyone to work independently while implementing several
of the required use-cases and entity classes. (This had increased the overall efficiency of our group to write code at a faster pace.)
The low coupling of our design has enabled us to carry out several modifications to our code with little effort and almost
no significant impact on other classes. Also, splitting our entities and use cases into different layers and classes has
made it much easier for us to implement our Interface Adapters. Thus, making changes and adding new features (by different group members)
is something which can be done well and seamlessly with our current design.

## What Each Group Member Has Been Working On And Plans To Do Next 

### Avnish
 Contributed to developing the CRC model and implementing the CRC flowchart on Whimsical. Implemented methods relevant to membership status of the user and calculating ticket discount. Also implemented methods relevant to user privileges such as lounge access. Wrote the specification document of the entire program system and assisted in developing the scenario-walkthrough document.
Plans to further increase the functionality of the membership-status related classes to allow users to upgrade from one category to another (eg from sliver to gold). Also, plans to add functionality for members to redeem their air-miles (points) to purchase online products. Also, plans to allow users to pay for their tickets using points or a combination of cash and points.

### Kevin
Helped in brainstorming project ideas and design layout. Implemented methods relevant to meal preferences and selection. Contributed to the development of the CRC model by raising questions and suggesting ideas to improve efficiency. Plans to increase the functionality of meal-class by increasing the meal options. Also, plans to add features such as calorie count, allergic ingredients and beverage preference to his classes. Also, plans to add a method to check passenger age before offering alcohol in their meals.


### Eeshan
Helped identify important design changes to the CRC model to follow the SOLID principle. Helped implement the CRC model on Whimsical. Contributed significantly to the development of the entire Interface Adapter layer of the program. Implemented a significant portion of the use case classes to interact with entities. Helped in the overall integration of the program with the command line. Helped plan and implement the scenario-walkthrough document.
Plans to further develop the User Interface to add more functionality to allow users to book/cancel and reschedule a ticket. Also, plans to create and add functionality for the AGENTS in our system and link the related Framework and Driver classes to the UI.
 

### Dixshant
Developed and implemented the baggage entity class. Created getter and setter methods for private attributes. Helped in the inter-design of classes and interfaces to reduce redundant dependencies between classes. Helped identify and eliminate several instances of duplication of code in the program. Plans to add functionality to store different check-in baggage dimensions and weight and calculate cost of excess baggage. Plans to do the same for cabin-luggage and add the excess price to the final cost of the ticket, while generating the ticket.


### Dinkar
Has contributed to the entity level development of the program. Designed and implemented the Seat class and its related subclasses – Economy, Business and First. Has implemented getter and setters for private instances. Has implemented methods to relate each class to its specific seat on a particular flight of a particular airline. Plans on implementing interfaces to relate amount of baggage allowed with each seat and calculate the price of extra luggage. Also, plans on implementing interfaces to calculate the refundable amount of each individual seat.
 

### Aryaman
Contributed to the efficiency of our CRC model. Contributed to the entity-level development of the program. Worked on developing the base structure for the Flight and Airline classes. Implemented getters and setters for private instance attributes of the Flight and Airline Classes.Further, plans to expand on the functionality of these classes with the SOLID principles in mind. Plans to implement methods to return the no. of occupied and vacant seats in a flight in Phase 1 of the project. In phase 1 also plans on working on the Airline Manager and the Ticket Manager. 


