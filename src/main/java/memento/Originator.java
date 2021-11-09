package main.java.memento;


public class Originator {

    Flight flight;

    public Flight getFlight(){
        return flight;
    }

    public void setFlight (Flight flight) {
        this.flight = flight;
    }

    public Memento makeMemento(){
        return new Memento(flight);
    }

    public void setMemento (Memento memento) {

        flight = memento.getFlight() ;
    }

    @Override
    public String toString() {

        return Originator [flight =];

    }

}
