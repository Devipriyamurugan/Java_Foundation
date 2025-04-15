package Task7.service;
import java.util.ArrayList;
import java.util.List;

import Task4.*;
import Task9.InvalidBookingIdException;

public class Bookingsystem {
	private List<Event> events = new ArrayList<>();
	private List<Booking> bookings = new ArrayList<>();
	
	public void createEvent(Event event) {
		events.add(event);
	}
	public void listEvents() {
		for(Event e : events) {
			e.displayeventdetails();
		}
	}
	public Event findeventbyname(String name) {
		for (Event e : events) {
			if(e.getEventname().equalsIgnoreCase(name))
				return e;
		}
		return null;
	}
	public void booktickets(String Eventname , List<Customer> customers) {
		Event e = findeventbyname(Eventname);
		if(e != null) {
			Booking b = new Booking(customers , e , customers.size());
			bookings.add(b);
			System.out.println("Booking Sucessfull");	
		}
		else {
			System.out.println("Event is not found");
		}
		
	}
	public Booking getBookingById(int bookingId) throws InvalidBookingIdException {
	    for (Booking b : bookings) {
	        if (b.getBookingId() == bookingId) {
	            return b;
	        }
	    }
	    throw new InvalidBookingIdException("Booking ID " + bookingId + " does not exist.");
	}
	

}
