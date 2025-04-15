package Task8;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Task4.*;
import Task5.Movie;
import Task7.*;


public class BookingSystemserviceproviderimpl implements IEventServiceProvider , IBookingsystemserviceprovider {
	private List<Event> events = new ArrayList<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    @Override
    public Event create_event(String eventname, LocalDate date, LocalTime time, Venue venue, int total_seats, double ticketprice, String event_type) {
    	Event e = null;
        switch (event_type.toLowerCase()) {
            case "movie":
            	e = new Movie(eventname, date, time, venue, total_seats, ticketprice, "Drama", "Hero", "Heroine");
            	break;
    }
        events.add(e);
        return e;
    }
    @Override
    public List<Event> getEventDetails() {
        return events;
    }
    @Override
    public int getAvailableTickets(String eventname) {
        for (Event e : events) {
            if (e.getEventname().equalsIgnoreCase(eventname)) {
                return e.getAvailable_seats();
            }
        }
        return 0;
    }
    @Override
    public Booking bookTickets(String eventname, List<Customer> customers) {
        for (Event e : events) {
            if (e.getEventname().equalsIgnoreCase(eventname)) {
                Booking b = new Booking(customers, e, customers.size());
                bookings.put(b.hashCode(), b); // or use bookingId
                return b;
            }
        }
        return null;
    }
    @Override
    public void cancelbooking(int bookingId) {
        Booking b = bookings.remove(bookingId);
        if (b != null) {
            b.getEvent().cancel(b.getNumTickets());
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Booking not found.");
        }
    }
    @Override
    public Booking getbookingdetails(int bookingId) {
        return bookings.get(bookingId);
    }
    
        }
	


