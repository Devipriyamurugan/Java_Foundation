package Task8;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Task4.Booking;
import Task4.Event;
import Task4.Venue;
import Task7.service.*;
import Task6.BookingSystem;

public interface IEventServiceProvider {
	Event create_event(String eventname, LocalDate date, LocalTime time, Venue venue, int total_seats, double ticketprice, String event_type);
	List<Event> getEventDetails();
	int getAvailableTickets(String eventname);
	
	

}
