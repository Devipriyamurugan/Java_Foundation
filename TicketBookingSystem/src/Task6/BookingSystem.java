package Task6;
import java.time.LocalDate;
import java.time.LocalTime;

import Task4.*;
import Task9.EventNotFoundException;

public abstract class BookingSystem {
	public abstract Task4.Event create_event(String eventname, LocalDate date, LocalTime time, Venue venue,
            int total_seats, double ticketprice, String event_type) throws EventNotFoundException;
	public abstract void displayeventdetails(Event event);
	public abstract void book_tickets(Event event, int numtickets);
	public abstract void cancelbooking(Event event, int numtickets);
	public Event create_event(String eventname, LocalDate date, LocalDate time, Venue venue, int total_seats, double ticketprice,
			String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
