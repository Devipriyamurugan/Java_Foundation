package Task6;
import Task4.Venue;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
	protected String eventname;
    protected LocalDate event_date;
    protected LocalTime event_time;
    protected Venue venue;
    protected int total_seats;
    protected int available_seats;
    protected double ticketprice;
    protected String event_type;
    public Event(String eventname, LocalDate event_date, LocalTime event_time, Venue venue,
            int total_seats, double ticketprice, String event_type) {
    	this.eventname = eventname;
        this.event_date = event_date;
        this.event_time = event_time;
        this.venue = venue;
        this.total_seats = total_seats;
        this.total_seats = available_seats;
        this.ticketprice = ticketprice;
        this.event_type = event_type;
    }
    
    public void book_tickets(int numtickets) {
    	if(available_seats > numtickets) {
    		available_seats-=numtickets;
    	}
    	else {
    		System.out.println("Not enough tickets " + available_seats + " Only Available");
    	}
    }
    public void cancelbooking(int numtickets) {
    	available_seats+=numtickets;
    	System.out.println("Canceled booking and seats updated");
    }
    public int getAvailableseats() {
    	return available_seats;
    }

	protected abstract void displayeventdetails();

}
