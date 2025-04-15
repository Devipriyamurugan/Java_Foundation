package Task4;
import java.time.LocalTime;
import java.time.LocalDate;

public abstract class Event {
	protected String eventname;
	private LocalDate event_date;
	private LocalTime event_time;
	private Venue venue;
	private int total_seats;
	private int available_seats;
	private double ticketprice;
	private String event_type;
	
	public Event() {
	}
	public Event(String eventname, LocalDate event_date, LocalTime event_time, Venue venue, int total_seats, double ticketprice, String event_type) {
		this.eventname=eventname;
		this.event_date=event_date;
		this.event_time=event_time;
		this.venue=venue;
		this.total_seats=total_seats;
		this.total_seats= available_seats;
		this.ticketprice=ticketprice;
		this.event_type=event_type;
	}
	public void bookingticket(int num) {
		if(num <=available_seats) {
			available_seats-=num;
			System.out.println(num + "ticket booked successfully");
		}else {
			System.out.println("not enough tickets available");
		}
	}
	public void cancel(int num) {
		available_seats+=num;
		System.out.println(num + "seats updated");
	}
	public int getbookednooftickets() {
		return total_seats - available_seats;
	}
	public double calculatetotalrevenue() {
		return (total_seats - available_seats) * ticketprice;
	}
	public void displayeventdetails() {
		System.out.println("\n eventname" + eventname);
		System.out.println("\n event_date" + event_date);
		System.out.println("\n event_time" + event_time);
		if (venue != null) {
	        venue.displayvenuedetails();
	    } else {
	        System.out.println("No venue assigned.");
	    }
		System.out.println("\n total_seats" + total_seats);
		System.out.println("\navailable_seats" + available_seats);
		System.out.println("\nticketprice" + ticketprice);
		System.out.println("\nevent_type" + event_type);
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public LocalDate getEvent_date() {
		return event_date;
	}
	public void setEvent_date(LocalDate event_date) {
		this.event_date = event_date;
	}
	public LocalTime getEvent_time() {
		return event_time;
	}
	public void setEvent_time(LocalTime event_time) {
		this.event_time = event_time;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	
	
	}


