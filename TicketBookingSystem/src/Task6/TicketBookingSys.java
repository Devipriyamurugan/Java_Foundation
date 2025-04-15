package Task6;
import Task4.*;
import Task5.*;
import Task9.EventNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;

import Task4.Venue;

public class TicketBookingSys extends BookingSystem {
	@Override
    public Task4.Event create_event(String eventname, LocalDate date, LocalTime time, Venue venue, int total_seats,
                              double ticketprice, String event_type) {
		if (event_type.equalsIgnoreCase("movie")) {
            return new Movie(eventname, date, time, venue, total_seats, ticketprice,
                    "Action", "Vijay", "Simran");
        } else if (event_type.equalsIgnoreCase("concert")) {
            return new Concert(eventname, date, time, venue, total_seats, ticketprice,
                    "ArtistName", "Rock");
        } else if (event_type.equalsIgnoreCase("sports")) {
            return new Sports(eventname, date, time, venue, total_seats, ticketprice,
                    "Football", "Team A vs Team B");
        } else {
        	return null;
        }
	}
	@Override
    public void displayeventdetails(Event event) {
        if (event != null) {
            event.displayeventdetails();
        }
    }
	@Override
    public void book_tickets(Event event, int numtickets) {
        if (event != null) {
            event.book_tickets(numtickets);
        }
    }
	@Override
    public void cancelbooking(Event event, int numtickets) {
        if (event != null) {
            event.cancelbooking(numtickets);
        }
    }

}
