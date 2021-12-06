# DESIGN DOCUMENT

## FUNCTIONALITY

### Project Specification

We seek to create a program on the Domain of an Airline Ticket Reservation system

- Our program should have a UI which would be able to accept data from the user, and use Classes in Interface Adapter 
  like BookingSystem and PassengerSessionHandler to do the following things:

  * Sign In/ Sign Up
  * Book tickets
  * Reschedule and refund tickets
  * view your account information
  * LogOut

- The system would be able to accommodate two different types of users, passengers and agents. We have not implemented
  the agent feature, but we plan to implement it in the future.

- The app would be able to Persist and load data using the DatabaseConnector, DataPullPusher, PassengerDataPullPusher, TicketDataPullPusher, and DataLoader classes.

- While booking a ticket, they would be able to search for flights, choose a seat, choose a meal plan, and add baggages to their ticket. Further they would be able to see receipt of this booking and finally the ticket printed onto the UI. This booking happens with the help of BookingSystem, and the UseCase classes it uses.

- The user would also be able to see their booking, and similar to booking a new ticket, they would be able to refund to reschedule the ticket. Refunding and Rescheduling is again done by Booking System and its UseCases.

- All the passengers have points (which increase by booking flight) and a membership (which upgrades with points) implemented by MembershipStatus and its subclasses. This membership provided discounts to the user while booking flights.

- In the future we plan to implement the agent feature, and The agent would also be able to do all the same tasks as the passenger. The only difference would be that the agent would be managing tickets on behalf of their customers.

### DATA PERSISTENCE   

To Persist data in our app we are using SQL. We are using a postgresql database storage server to store data of our users and the tickets they have booked. We have created an Airline database on the server with two tables namely users and tickets. We then have a class called DatabaseConnector that connects to the server and helps run queries. The DataPullPusher interface ( implemented by PassengerDataPullPusher, and TicketDataPullPusher) then use this DataConnector class to load all the users and tickets before the app starts (This data is loaded by a gateway class called DataLoader), and update the tables with the user actions, which include booking, rescheduling and refunding a ticket.

Thus, our program is able to store state and load state. Also, this state can persist across runs of our program.


### Reflection of the specification!

We believe that the program does what the specification intends that it would do

### Any changed functionality and is the functionality sufficiently ambitious given the size of your group?

Initially we had planned to also implement the Agent interface for our program which would also allow agents to use our system. However, due to the recent decrease in our group size from 6 to 5 members and upon discussing with the TA we decided to leave the Agent implementation part of our program for the future. We did this to reduce part of the complexity given the amount of time we had to implement our project.

### Any major design decisions?

All major design decisions were generally centred around which design patterns we had to implement and which area do we need to implement them in. This is described in the Design Pattern section of this document. All such decisions were taken collectively as a group with everyone contributing equally.

## CLEAN ARCHITECTURE

### CRC Model

We have created our CRC model on a site called Whimsical, which helps make flow charts. [Here](https://whimsical.com/phase-2-HpgVrt2RncuQaPvNnt2YSn) is the link to our model. You don’t need to be signed in to view the model.

Alternatively, you can click on this link:
[https://whimsical.com/phase-2-HpgVrt2RncuQaPvNnt2YSn](https://whimsical.com/phase-2-HpgVrt2RncuQaPvNnt2YSn)


### SCENARIO WALKTHROUGH

- When the program is run, the CmdUI class asks the user (in the command line) if they are a User or an Agent.

- If the user selects that it is a USER, the CmdUI class would ask if the user wants to sign-up or sign-in. For the sake of our scenario-walkthrough, we select the sign-in option.

- The CmdUI class then prompts the user to input their sign in id. CmdUI then asks passengerSessionHandler to sign_in to the app with the specific id.
   Note that for signing in, the passengerSessionHandler is only dependent on BookingSystem and UseCase classes. 

- After signing in, a menu opens using the CmdUI class. It gives you option to book a ticket, view your bookings. For the sake of this walkthrough we would book a new ticket.

- To book a new ticket CmdUI first prompt the user to fill in the information of the flight, seat, meal they want to select. To get this information of flights, the CmdUI uses passengerSessionHandler, which further only uses BookingSystem and UseCase classes to get the information.

- Using the BookingSystem and TransactionPresenter the CmdUI then prints out the transaction details of the booking. Note that here for generating the transaction the bookingSystem is only dependent on UseCase classes, specifically TransactionManager.

- If the users wishes to proceed, the CmdUI uses the BookingSystem and TicketPresenter to book the ticket and print out the ticket. Note that here for generating the ticket the bookingSystem is only dependent on UseCase classes, specifically TicketManager.

- The user then is returned to the menu after the ticket is booked and chooses to end the app.


### Are there any clear violations if we were to randomly look at the imports in a few of your files? 

The flight entity is depending on the seatFactory which is a UseCase to create a seatMap for the flight. Other than that we don’t think there are any such violations in our program.

### Is the Dependency Rule consistently followed when interacting with details in the outer layer?

The dependency rule is clearly followed throughout our entire project and this can be seen via a walkthrough of how we load data from our database. It could be helpful to look at the CRC model along with this walkthrough.

As soon as the app is launched, the CmdUI class generates instances of PassengerDataPuller and TicketDataPuller classes. Both of these classes implements DataPullPusher interface. 

These instances are passed into passengerSessionHandler, as DataPullPusher, and not as PassengerDataPuller and TicketDataPuller. 
The passengerSessionHandler, then uses DataLoader class (Also a gateway) which loaded the data into our app using these two instances of DataPullPushers into booking System. Here DataLoader is only dependent on DataPullPusher, BookingSystem and UseCase classes.


## SOLID

How does your program follow the SOLID principles?

### Single Responsibility Principle:

Our program follows the single responsibility principle of SOLID since many classes are isolated from other irrelevant classes and most importantly, have only one reason to change.
Some examples of these include the meal class since if we were to ever need to add a parameter to our meals such as the sodium content of meals, we would not need to make a change anywhere else in the code except our meal class due to its adherence to SOLID design principles. The user abstract class would only have one single responsibility of storing user information no matter the type. The adherence to this principle makes the class incredibly easy to maintain. The baggage abstract class has the sole objective of creating a bag with the appropriate attributes and does not employ any other methods to fulfill unrelated tasks. The Seat class’ subclasses (EconomySeat, BusinessClassSeat, FirstClassSeat)
are responsible for one task, adhering to a specific type of seat. The Classes (Standard, Silver, Gold, Platinum) that implement the MembershipStatus interface each have the sole objective of creating different Membership tiers that have unique discounts.

### Open/Closed Principle:

Our program follows the Open/Closed Principle since many classes are open for extension by adding features but also closed for modification in terms of their core basis. Some examples of these include the user abstract class and its subclass Passenger since we are able to add many more types of users without worry of any more modifications to code than just the additional user type. Once the subclass is added, no higher level of code needs to be touched for functionality to remain, making development and extension much easier on us. Another occurrence is the baggage class along with its subclasses CheckinBaggage and CabinBaggage. The Seat superclass and its subclasses (EconomySeat, BusinessClassSeat, FirstClassSeat)  are formatted based upon the template design pattern; we can add different types of seats without making any significant changes to the core parts of this program. For example, if we wanted to have a private jet seat, we would simply need to create a PrivateJetSeat subclass of the Seat superclass, implement corresponding methods, and we are done. The Classes (Standard, Silver, Gold, Platinum) that implement the MembershipStatus interface, since they are formatted based upon the template design pattern, we can add different types of member “subclasses” without making any major changes to our existing code. The new classes can simply implement the interface and extend the functionality of our existing features. Features of each class are also open for extension to allow more perks apart from just discounts to be provided.

### Liskov Substitution Principle:

Our program follows the Liskov Substitution Principle since many subclasses of a parent class can be substituted/replaced by other subclasses of that parent class. This implies that all the subclasses behave in the same manner as their parent class. Some examples of these include, the baggage class along with its subclasses CheckinBaggage and CabinBaggage since the subclasses only extend the usage of the abstract baggage class by filtering 2 different types of bags and calculating their independent prices. Other instances of this principle being applied for a very similar reason are Seat abstract parent class and its subclasses (Economy, BusinessClass, FirstClass), MembershipStatus interface and the classes(Standard, Silver, Gold, Platinum) that implement it.

### Interface Segregation Principle:

Our program follows the interface segregation principle since we have not implemented any unnecessary interfaces that have unused methods within them. Some examples of these include the MembershipStatus interface and the classes that implement this interface since all of the functions from MembershipStatus are implemented by all of these classes, avoiding having any unnecessary functions. By following the Interface Segregation principle here, we have also avoided the code smell of refused bequest, which refers to having unused methods.

### Dependency Inversion Principle:

Our program follows the dependency inversion principle since we have formed abstractions, usually via a parent class or an interface, to avoid direct dependency of high level classes on low level classes. This also allows our program to have low coupling and invert the source code dependency. Some examples of these include, the SeatManager and Seat since our SeatManager, a use case class, does not depend on these subclasses of Seat (Economy, BusinessClass, FirstClass) directly, it merely depends on an abstraction, the Seat abstract class. The MembershipStatus interface and MembershipFactory also adhere to this principle since the different classes (Standard, Silver, Gold, Platinum) implement the MembershipStatus interface,  where the MembershipFactory depends on an abstraction (MembershipStatus), instead of the classes directly.

### Some improvements which we can make in our design to follow SOLID principles

Although our program follows all of the SOLID principles in one way or another, there are instances where we believe some principles are not applied significantly. For example, since our program only has two interfaces, MembershipStatus and SeatBaggageAllowance we feel that our program lacks having interfaces, implying that we also lack the application of the interface segregation principle. If our program contained more interfaces, we feel that it would better show how our program follows the interface segregation principle in multiple sectors apart from just one occurrence in the entities and once in the use cases. We have not found many additional places to incorporate interfaces in our program but if we were to keep working on this project via adding new features, there may be occurrences of source code dependencies that we might run into. To avoid this we would need to create new interfaces which would work in favour of us applying the Interface Segregation Principle as well as the Dependency Inversion principle.

Another place where we acknowledge we could have made a better design choice would be in the RefundAndRescheduleSeatPriceCalculator class. Although this class, by definition, is tasked to calculate the refund price for a ticket and the cost of changing a departure date, it can be argued that this violates the single responsibility principle. In retrospect, we could have broken this class into 2 different classes each responsible for calculating the respective numbers. Just on the basis of time, we have decided to keep this as a TODO for the future.


## Design Patterns

### Phase 1

We have implemented two design patterns upon the Seat superclass and its subclasses. Firstly, since Seat is an abstract parent class, and it has different types of seats as its subclasses, this is a clear implementation of the Template Design Pattern. In general, the template pattern helps the Seat abstract class be seen as a way to provide us with different implementations of its methods within its subclasses.

Additionally, we have also applied the Simple Factory Design Pattern by creating a SeatFactory class that allows us to create different types of Seat objects (Economy, BusinessClass, FirstClass) without showing how they are formed to the client. These two implementations can be seen in the pull request called “Main dinkar”, as well the implementation of the MembershipFactory class.
Another similar use of the Template method design pattern, in our project, is when we create an abstract Baggage class which contains information about baggage. We then create two subclasses called Cabin Baggage and CheckedIn Baggage which inherit the Baggage abstract class. The sub-classes can then override the abstract methods to account for the variation in baggage type while re-using most of the similar code.

We have also implemented the Observer Design Pattern in the TicketManager and PassengerManager Class. We have made the TicketManager class the Observable Class and the PassengerManager the Observer Class. By implementing this pattern, the PassengerManager class gets notified whenever a passenger has booked a ticket. This is helpful as it notifies the PassangerManager to take the necessary action, such as updating the points of the passenger who has booked the ticket and their membership status. This implementation of the Observer Design Pattern can be found in the pull request called “Phase1-Avnish”.
Also a part of the implementation for the Simple Factory Design Pattern for the MembershipFactory class can also be found in “Phase1-Avnish” as well as the “Main dinkar” pull requests.

We have also implemented the Iterator Design Pattern in the TicketManager, TransactionManager, PassangerManager, AirlineManager, Airline, Flight and MealManager Classes. Since we were implementing the Iterator Design Pattern in so many classes, we created a generic GeneralIterator.java class which we called in the above mentioned classes to implement our iterator design pattern. By implementing this design pattern, we are not having to expose the underlying representation of how the elements are stored in a particular class. This can be found in the “Phase1 eeshan” pull request.


### Phase 2

We have also implemented the Decorator Design Pattern for the MembershipStatus and Seat portion of the code to provide us to add new features upon these dynamically. An example feature includes people of disability are allowed to have additional cabin and check in baggage regardless of their type of Seat. An application of the decorator design pattern can be seen in the “phase2_dinkar” pull request. Another example feature includes that people of disability get an additional 10% discount on top of their membership status discount. An example of this feature in another decorator design pattern can be seen in the pull request named “Avnish phase2”. In the future, we may simply add subclasses to the MembershipDecorator and the SeatDecorator abstract classes to allow new features to be added onto our Membership program and the Seats without any hassle; hence leaving it open for extension.

### Identify and describe any patterns that could be applied in future with more time?

To facilitate booking of a ticket, we have partially implemented the Memento Design Pattern. This design pattern functionally allows us to carry out a rollback operation which restores the state of a class to a previous version. We have used this pattern to store mementos of the state of the available seats in a plane, and if a user decides to change/cancel seats, the map of the seats is restored to what it was before the booking had been made. With more time, we are looking to extend the functionality of this design pattern by allowing for this rollback operation to be carried out on the meals and baggage of the user too so that if a user decides to change meal preference mid booking, the can restore the state of the ticket to just before the meal was chosen, instead of starting the entire procedure again. This can be seen in the pull request memento design pattern in branch phase1dix

## USE OF GITHUB FEATURES

Our group made extensive use of GitHub features by creating commits for each activity that was being completed along the way. This can be seen from the commit history in the main branch on GitHub. Also, all group members made extensive use of creating issues. The issues mentioned which design patterns could be implemented (while pointing to specific classes) to optimize our code. Issues were also posted regarding which Code Smells were found and needed to be corrected. Also, issues were created to refactor poor code and improve it. Regular pull requests were made to the current branch for all group members to get an updated version of the code and resolve any merge conflicts which may have arisen.

## Code Style and Documentation

We have ensured to maintain a good coding style and documentation. All our files have appropriate documentation explaining what the code is doing. All our coding styles use simple variable and function names which can be understood by the average user and programmer. The names are descriptive in nature, giving us an idea of the primary task of a variable or function. Furthermore, all IntelliJ warnings have been fixed. Also, all pull requests have been reviewed before merging to the main branch and all code conflicts have been resolved. At all stages of writing our code, we have ensured to follow good coding practices.

## TESTING

What did your group test?

### Entities

TestEconomySeat, TestBusinessClassSeat, TestFirstClassSeat: These test classes refer to testing the subclasses of Seat. They test the different getters and setters of each class, as well as whether each seat type corresponds to the correct baggage allowance we have given it. For example, we tested whether Economy Seat only allows 1 cabin bag to the passenger.

TestStandard, TestSilver, TestGold, TestPlatinum: These test classes refer directly to the classes implemented by the MembershipStatus interface. They simply test the various getters and setters in each corresponding class. They also make sure that each Membership type corresponds to the correct discount value we have set in each class. For example, we have tested that a standard membership provides only a 10% discount in each corresponding method of that class.

TestBaggage, TestCabinBaggage, TestCheckInBaggage: These test classes all test Baggage and both of its subclasses. They thoroughly test all the methods, (such as getters and setters) in each of them. Other important methods tested include creating a new baggage and seeing if it correctly identifies it as overweight or not.

TestMeal: This test class specifically verifies that our Meal class is working correctly. It creates a new meal object with predetermined parameters and then examines if the getter and setter functions are returning the correct value.

TestPassenger: This test class takes the Passenger class and verifies that its getters and setters are working as expected. It starts by creating a new passenger object then asserting its methods are returning what is needed.

TestTicket: This test class takes the Ticket class and verifies its output is what we want. It starts by creating a new ticket object and then asserts that the methods are returning the correct objects since the Ticket class merges other objects together.


### Use cases

#### Decorators

TestDisabilitySeatDecorator: This file tests the functions in the DisabilitySeatDecorator class. In general, it ensures that disabled people are able to get an additional cabin and check in bag, regardless of their seat type.

TestDisabilityMembershipDecorator: This file tests the functions in the DisabilityMembershipDecorator class. In general, it ensures that disabled people are able to get an additional 10% discount, regardless of their Membership status.

Factories:
TestMembershipFactory: This file tests the functions contained in the MembershipFactory class. The testGetMembership function tests whether getMembership returns the correct types of objects of Membership (Standard, silver, gold and platinum). The testSetMembership function tests whether setMembership is able to switch the membership status of a passenger based on how many points they have and the given points threshold.

TestSeatFactory: This file tests the functions contained in the SeatFactory class. The testGetSeat function tests whether getSeat returns the correct types of objects of Seat (EconomySeat, BusinessClassSeat, FirstClassSeat).

#### Factories

TestMembershipFactory: This file tests the functions contained in the MembershipFactory class. The testGetMembership function tests whether getMembership returns the correct types of objects of Membership (Standard, silver, gold and platinum). The testSetMembership function tests whether setMembership is able to switch the membership status of a passenger based on how many points they have and the given points threshold.

TestSeatFactory: This file tests the functions contained in the SeatFactory class. The testGetSeat function tests whether getSeat returns the correct types of objects of Seat (EconomySeat, BusinessClassSeat, FirstClassSeat).


#### Helpers

TestFlightFilter: This tests the FlightFilter class for its functionality of returning the available flights of a particular airline. The available flights returned must match the arguments passed into its constructor and must be of the specified airline.

TestRefundAndRescheduleSeatPriceCalculator:  This tests the methods of RefundAndRescheduleSeatPriceCalculator class. It tests whether the calculateRefundByDaysLeft method and calculateDateChangeChargeByDateLeft return the correct numerical depending on the formula used to calculate these values.

TestTicketFilter: This test class is testing the TicketFilter in its functionality of being able to successfully filter the tickets based on the passengers id

TestRescheduleTicketTransactionCreator: This test class tests the RescheduleTicketTransactionCreator class to see whether the correct transaction is created when a user changes their ticket

TestNewTicketTransactionCreator: This class tests the NewTicketTransactionCreator class for its functionality of producing the correct Transaction according to the given arguments


#### Managers

TestAirlineManager: This class is testing the AirlineManager in its functionality of adding and getting airlines from its storage space. The method testAddAirline tests if the airlines are being added to the arraylist properly by checking the size of the array before and after the insertion of airline and also asserting whether a given airline is in the correct index of the list which depends on when the airline was added. The method testGetAirline is asserting if the airline at index 0 is the same airline that is returned by the GetAirline function when the index 0 is passed.

TestPassengerManager: This class is testing whether the Passenger manager is properly adding to the list of passengers when a new one is created by asserting the size has increased by 1 and the proper ID number is assigned.

TestTicketManager: This class is testing the Ticket manager by creating the required objects for the manager to work, running the method and checking to see if an instance of ticket was created.

TestMembershipManager: This file tests the function contained in the Membership Manager class. The testCalculateLoungeAccess and the testCalculatePointsForLoungeHours function test whether the corresponding functions return the correct amount of hours and points.

TestMealManager: This file tests if there are any meals in the system. This file also tests the functionality that meals are getting added correctly to the menu. This test file also checks if the system correctly returns a meal requested by the user, if that meal is present in the system.

TestBaggageManager: This file tests that after all the discounts and rebates relating to a users membership status, discounts and addition of any extra penalties, the cost remains a positive number so that the airline can turn a profit. If the cost is a negative number, it would mean that we must increase the price per baggage so that at the end of the day the airline does not make any loss.

### Components that were a bit difficult to test

The Reschedulemanager class incorporates usage from another manager called TicketManager. This implementation would be more of a challenge to test since if a particular test results in a fail, it could mean either class failed and we would not know which part to fix exactly.

## REFACTORING

### Code Smells and other minor refactorings!!

#### Phase1

Initially in phase 0, we had redundant interfaces being implemented by the parent class Seat and the interface MembershipStatus, but since they already contain these methods, where their subclasses implement these methods, there was no need to keep the redundant interfaces. This refers to the code smell of Dead Code, and the quickest way for us to fix this issue was to apply the Collapse Hierarchy treatment by merging the redundant interfaces with either Seat or MembershipStatus, and deleting the redundant interfaces.


To avoid having the Duplicate Code, code smell, we shifted certain functions from the Seat parent class and its subclasses, as well as the MembershipStatus interface and its subclasses, into “Manager” classes. This also allowed us to follow Clean architecture since these entities contained functions that should not be there, but after this refactoring, the use case Managers now contain these functions instead. The change to fix duplicate code can be found in the pull request called “Main dinkar”.

When looking at places to refactor our code, one code smell we came across was Change Preventers within the User class. We noticed that everytime we tried to make changes in any of the subclasses, we had to change the superclass to accommodate for it. We noticed this flaw relatively early when adding the agent subclass. To fix this, we did the divergent change and split up the behaviours in the User abstract superclass. This is because we managed to divide functionality into subclasses so it not only fixed our initial problem, it also made our program better abide by SOLID design principles. These adjustments to fix the change preventers code smell can be found in a pull request called “Seat.”

When reviewing our code, we encountered the Bloater code smell in one of our methods in the CUI called findFlight. This method was initially programmed to execute 2 big tasks. First, it was prompting the user to enter their travel details so that the program can display all the flights available that match the users criteria. Second, the same method was responsible for asking the user to choose their flights. Since this method was turning out to be very long, we decided to split the method into 2 different methods which would each carry out their own separate tasks. We implemented the flightSearchFilter method that searches for the flight from the database depending on the user's input. If there is a flight in the database, this method calls on the whatToDoWithFlights method to allow the user to choose which flight to book. Hence, by breaking a big method into smaller methods, we were able to prevent the Bloater code smell.

When reviewing our code, we also came across the Bloaters Code smell for Large Class. This was present in the TicketManager class which was too large. We resolved this by placing the presenter/display methods in another class called TicketPresenter and the transactions related to the ticket in another class called TransactionManager. This can be seen in the “Phase1 avnish” pull request.

We also detected the code smell Dispensables - Duplicate Code in the AirlinesManager class. Over here the methods getAirline and setAirline were making use of a lot of similar code. This issue was resolved during refactoring for our Phase 1 code. This can be seen in the “Phase1 eeshan” pull request.

We also detected the same code smell Dispensables - Duplicate Code in PassangerManager class. We had similar code in getPassangerWithId and removePassangerWithId. This code smell got automatically resolved when we made changes to the functionality of our program which resulted in changes to the return types and internal code of these methods. This can be seen in the pull request “Phase1 avnish”.

We also detected the Bloater Code Smell for Large Class once again in the AirlineManager class. This class was too large. To resolve this issue, we extracted the presenter/display methods of this class to two separate classes called FlightPresenter and SeatMapPresenter. Also, we detected another bloater code smell for a long parameter list in the constructors of the Ticket Class and resolved that code smell. This can be seen in the pull request named “Phase1 eeshan”.

#### Phase2

Initially in phase 1, we missed the code smell of divergent change within our classes (Standard, Silver, Gold, Platinum) that implement the MembershipStatus interface. This code smell is referring to the fact that each class has discount “hard coded” into each method of the corresponding class. If we wanted to make a change to this discount, we would have to make a change in every single method of the class which is this exact code smell. To avoid this, we simply created a data variable that stores the discount percentage that is used by each method instead of the “hard coding”. This can be seen in the pull request, “phase2_dinkar

We also had the issue of contradicting the single responsibility principle in our MembershipFactory class since it was responsible for more than what a factory class should do. We refactored this issue by forming a MembershipManager that now includes these “extra” functions that used to be in the MembershipFactory class. By forming a MembershipManager, we are also leaving this class as being open for extension, but closed for change, hence following the Open/Closed Principle. Additionally this split also leaves room for avoiding the large class code smell.
This can be seen in the pull request, “phase2_dinkar.

The TA mentioned an “issue” with the design of our Membership and Seat portion of our entities. This issue refers to a potential extensibility difficulty of, for example, allowing the disabled to have additional baggage, having holiday discounts, etc. To allow features like these to be implemented, we applied the decorator design pattern. This pattern allows us to override new features on top of pre-written ones, for example, giving people with disabilities an extra cabin bag regardless of the type of Seat they have.

We also removed some unused imports in our presenters to avoid having the dead code, code smell.

Above are a few examples of refactoring which our team encountered. We encountered several other code smells as well which our team resolved along the way. Our team also refactored the code by implementing several other design patterns on the code from Phase 0 and phase 1 as highlighted in the Design pattern section of our document.

The upper layers, that is interface adapters, Database connectors and UI were depending on the Entities, thus we were not following clean architecture. To resolve this problem we introduced Factories which took out the data from the entities into Maps of data representing that Entity. In the upper layers we used these maps instead of using the entities. Now none of our classes in the interface adapter or Database connector classes are depending on entites.

Our Database handler was  an interface adapter, which was directly connected to the database. This also violated the rules of clean architecture. To fix this issue we shifted the loading of the data (in the database) from IA  to the outer layer and made a gateway class (DataLoader) to interact with the Data connector classes through an interface called (DataPullPusher). This solved the problem we had before. 

#### Above are a few examples of refactoring which our team encountered. We encountered several other code smells as well which our team resolved along the way.

#### Our team also refactored the code by implementing several design patterns on the code from Phase0 as highlighted in the Design pattern section of our document.


### Are there any obvious code smells still in your code that you missed fixing?

So far as we have reviewed our code, at this point of time, we cannot seem to find any more code smells or refactoring errors. We have taken every feedback from the TA into consideration and applied it directly within our program to avoid having code smells, clean architecture issues, contradicting SOLID design principles and general design flaws.

## CODE ORGANIZATION

### Is your code organized in a meaningful way? Is it easy to find things in your package structure?

Yes! We believe that our code is organised in a meaningful way. We have used the Package-by-Layer packaging structure. This essentially means that we are packaging our code by each layer of Clean Architecture.

In this packaging structure, all our Entities would be in a single package/folder, all our Use Cases would be in another package/folder, all our Controllers/Presenters/GateWays would in in another package/folder and our Devices & User Interface would be in a separate package/folder.

This would make it a lot easier for someone to find the code to a particular function or class. This is because they would just need to check if the code they need to edit is present/located in an entity class, use case class, presenter/gateway class or in devices/user interface class.

One look at our CRC model would explain how the Package-by-Layer packaging structure made the most sense. Our CRC model already shows our classes, interfaces and abstract classes divided up into layers of clean architecture. It would only make sense for us to leverage the work we already did (by dividing up our classes by layers of clean architecture) and implement it in our packaging structure.

## ACCESSIBILITY REPORT

 ### For each Principle of Universal Design, write 2-5 sentences or point form notes explaining which features your program adhere to that principle.
      
####Principle 1: Equitable Use
      
- Our design is useful and marketable to people no matter their diverse abilities. To better adhere to this principle, we could add a voice detection feature that could accommodate those who can’t type on a keyboard for example. We could also add a bigger text option for those who have difficulty reading the small text we currently have.
      

####Principle 2: Flexibility in Use
      
- Currently, there are a few ways we can improve our flexibility. For example, we could look into implementing different languages apart from just English to open it up for more users. We could also do something like a drop down menu for people to select in case the user’s typing accuracy gives them problems.
      

####Principle 3: Simple and Intuitive Use
      
- Our current design is already very simple to understand and simple to use with our type inputs. However to improve in this area, we can display the data the user already input for them to see at all times. If people are not accustomed to typing in the console, we could implement a GUI with buttons to accommodate all user’s experience.
      
####Principle 4: Perceptible Information
      
- Our current design communicates the essential information to the user which is good. However currently it is only in textual mode. We could expand this into more pictures, verbal, or tactile versions to present information to the user however they need it. We could also add colour to our text to help with contrast and legibility. We could also make the displayed seat chart more readable.
      
####Principle 5: Tolerance for Error

- In our design, the user must type the word spelt correctly or else our program would not accept it. This aspect could be fixed by adding an autocorrect or an autofill option. We could also implement warning messages that would show up to discourage potential errors in usage such as booking a flight to the same starting destination.
      

#### Principle 6: Low Physical Effort
      
- This principle would not apply to our program. This is because we already only take the minimum amount of information required to book something as complicated as a ticket. We also handle the additional features such as air miles and rewards in the background so the user would never have to interact with it. Since the user only has to remember their sign on information, we could implement a remember sign in information to reduce physical effort.
      
#### Principle 7: Size and Space for Approach and Use

- This does not apply to our program. Our program is as accessible for size and space as a typical keyboard is. There is nothing to reach for in our program since all operations are done on the keyboard. 

### Write a paragraph about who you would market your program towards, if you were to sell or license your program to customers. This could be a specific category such as "students" or more vague, such as "people who like games". Try to give a bit more detail along with the category.

We would like to market my program to the Airline Industry. This is because we have created an Airline Ticket Reservation system. We feel that our program/system would help airlines book and manage tickets better since our program includes features to book, cancel and reschedule a ticket. It also accounts for membership programs with the airline and can also input a user’s meal and seat preferences amongst many other features. Since our program follows Clean Architecture and the SOLID principles, it can easily be modified to suit the customer’s requirement.
On a broader perspective, we can also market our system to any agency which needs a program to book and manage tickets. This could be the railway agency (who would need to keep track of railway tickets) or a movie theatre (which would also need to keep track of tickets). Since our program follows a modular design, we could easily adapt our program to suit the needs/requirements of a wide range of industries and market our program to a huge consumer base.


### Write a paragraph about whether or not your program is less likely to be used by certain demographics. For example, a program that converts txt files to files that can be printed by a braille printer are less likely to be used by people who do not read braille.

Our program could potentially be less likely to be used by certain demographics in its current state. This could include groups such as people with dyslexia, or those who have difficulty inputting into a keyboard. For dyslexic people, the only text interface could interfere with their ability to read and understand what they are doing. This could cause them to choose a ticket booking service with more visuals and much bigger text than what we have currently implemented. Since our entire program is reliant on the users keyboard inputs, if someone were to have trouble using it, it would discourage their use.


## INDIVIDUAL CONTRIBUTIONS & FINAL THOUGHTS

### Dinkar:
In phase 2, Dinkar has contributed to reformatting and improving our design document to suit the necessary changes we have made. He has also helped write tests for many classes within our code, helped write javadoc where necessary, helped refactor our program in certain areas to adhere to the SOLID principles, and implemented the decorator design pattern to provide an easy road of extending specific areas of our program. The pull request outlining my effort during phase 2 has been outlined in the pull request: https://github.com/CSC207-UofT/course-project-anonymous/pull/40
I believe that is a significant contribution to my team since I have helped in all sectors of the project where needed that goes beyond just programming in this pull request. The same goes for my teammates, since we had limited time some teammates may have contributed less to coding simply because we did not have time to write much code that extends our program. The amount of commits in our code by each teammate does not uphold the commitment provided by their effort in pushing towards a great group project.

### Kevin:
For phase 2, Kevin has contributed to all needed aspects in order for us to complete our project for submission. This includes writing and editing parts of the design document, identifying areas within our code that needed to be refactored, implementing the suggested javadoc format across our program, and creating many tests to ensure correct functionality. This can be seen within this pull request: https://github.com/CSC207-UofT/course-project-anonymous/pull/41
This pull request contains some of the code that Kevin has contributed for phase 2. On top of this, aspects of the part 2 design document writeup were researched and written by him such as the accessibility report, testing documentation, and javadoc. Kevin along with everyone else helped to ensure an efficient and positive working environment that resulted in a submission we are all proud of.


### Avnish:
For phase 2, Avnish has contributed to refactoring the code such that it follows the SOLID principles. He has also helped in writing and editing the Design document and updating the CRC model to reflect the latest changes made during phase 2. He has also helped in identifying and removing dependencies from classes as well as adding javadoc to missing files. He has also written several missing test classes to test the code extensively. Avnish also implemented the decorator design pattern as well as the simple factory design pattern to allow for easy extension of our program in the future. Apart from this, he also helped research and write up the Accessibility report for phase 2. Throughout phase 2, Avnish actively engaged in discussions with his peers to discuss new implementation strategies, refactor code and improve the overall efficiency of our project. He also put forward new ideas and assisted in trouble shooting to help the team. My contributions can be seen in my pull request for Phase 2:
https://github.com/CSC207-UofT/course-project-anonymous/pull/52
I think that this pull request demonstrates a significant contribution to my team since it highlights how I have made significant contributions to my team by implementing several design patterns, writing test suits, adding missing documentation and overall refactoring of the code such that it follows Clean Architecture, adheres to the SOLID principles and makes the class more extensible for future changes. I believe that this pull request highlights a significant contribution to my team since it demonstrates how I have made an effort to assist and help in all aspects (like design document, accessibility report etc) and domains of our project which needed to be addressed.

### Eeshan:
Eeshan has contributed significantly for Phase 2. He has helped in removing several inter-class and inter-layer dependencies in our code, such that it follows clean architecture and adheres to the SOLID design principles. Eeshan has implemented new presenters and interfaces to allow for high decoupling of our system. He has helped write up the Design document and make significant contributions to modifying the CRC model to reflect the new changes made during phase 2. Eeshan has written test classes to test our code and added java documentation wherever required. Throughout phase 2, he has significantly and extensively refactored the existing code to follow the SOLID design principles and remove dependencies, based on TA feedback, and adhered to Clean Architecture. He has contributed to group discussions and helped resolve several coding and merge conflicts which have risen during phase 2. Eeshan has also helped resolve the login page errors which our group was running into during Phase 1. He has also made significant contributions to linking our program with an online database to improve the scope and expandability of our project. He has also engaged in several discussions to help improve the overall efficiency of our program. His contributions can be seen in the pull request :   https://github.com/CSC207-UofT/course-project-anonymous/pull/55
I believe that this is a significant contribution to my team since it highlights how I have been actively engaged in all aspects of our project during Phase 2 and helped improve our project since Phase 1 based on TA feedback. This pull request also highlights how I have made a genuine effort to assist my team in refactoring code and resolving issues we encountered during Phase 1.

### Dixshant:
For Phase 2, Dixshant contributed significantly to the refactoring of the code to remove any last remaining code smells where IntelliJ would give stylistic errors and made sure any new classes added adhered to the solid principles. He actively provided ideas to make the code open for future extensions during our team meetings and helped in completing the design document. DIxshant was also working on the memento design pattern for a possible future extension to our program which would make re-booking of tickets significantly more efficient. Dixshant also wrote several test classes to fix any last remaining edge cases and added Java Docstrings wherever necessary. The pull request outlining some of his contributions can be found at the following link. https://github.com/CSC207-UofT/course-project-anonymous/pull/57
Overall, Dixshant actively engaged in team discussions to create a intellectually stimulating environment for everyone and his contributions helped in making the code for efficient. 


#### We are proud to say that each member of our group has contributed EQUALLY and extensively in making this Phase 2 project submission a success. Each group member actively engaged in discussions and contributed their perspectives while making design and functionality decisions. Each group member was actively involved in writing and fixing the code, as well as in creating the Design Document. We, as a group, strongly believe that Phase 2 submission is our collective collaborative effort which has seen EQUAL participation and contribution by each member of the group.

### Open questions your group is struggling with? 

Extensions: For our current implementation, our flight data is from a predefined set we created without API’s or real time data. In order to extend our program, we thought it would be a good idea to generate new flights but we would require more time to look into ways to create it and also to reliably test it. Doing that part could also further expand into getting and loading real world data of flights into our program which we believe would require elements like web scraping to do, which we would have to learn.

### What has worked well so far? 

So far splitting up our program into entities and use cases (by using the SOLID design principles) has worked out well so far. This has helped reduce inter-class dependencies and allowed everyone to work independently while implementing several of the required use-cases and entity classes. (This has increased the overall efficiency of our group to write code at a faster pace.) The low coupling of our design has enabled us to carry out several modifications to our code with little effort and almost no significant impact on other classes. Also, splitting our entities and use cases into different layers and classes has made it much easier for us to implement our Interface Adapters. Thus, making changes and adding new features (by different group members) is something which can be done well and seamlessly with our current design.


















