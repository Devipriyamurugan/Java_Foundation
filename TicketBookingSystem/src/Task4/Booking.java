package Task4;
import java.time.LocalDateTime;
import java.util.List;

public class Booking {
	private static int bookingcounter = 1000;
	private int bookingId;
	private List<Customer> customers;
    private Event event;
    private int numTickets;
    private double totalCost;
    private LocalDateTime bookingDate;
    public Booking() {
        this.bookingId = bookingcounter++;
        this.bookingDate = LocalDateTime.now();
    }
    public Booking(List<Customer> customers ,Event event, int numTickets) {
        this.bookingId = bookingcounter++;
        this.customers=customers;
        this.event = event;
        this.numTickets = numTickets;
        this.bookingDate = LocalDateTime.now();
        calculateBookingCost(numTickets);
    }
    public void calculateBookingCost(int numTickets) {
    	if (event != null) {
            this.totalCost = event.getTicketprice() * numTickets;
        }
    }
    public boolean booktickets() {
    	if(event.getAvailable_seats()>= numTickets) {
    		event.setAvailable_seats(event.getAvailable_seats()-numTickets);
    		this.numTickets+=numTickets;
    		calculateBookingCost(this.numTickets);
    		System.out.println(numTickets + "ticket booked");
    		return true;
    	}else {
    		System.out.println("not enough tickets available");
    		return false;
    	}
    	
    }
    public void booking(int numoftickettocancel) {
    	if(numoftickettocancel < numTickets) {
    		event.setAvailable_seats(event.getAvailable_seats() + numoftickettocancel);
    		this.numTickets-=numoftickettocancel;
    		calculateBookingCost(this.numTickets);
    		System.out.println(numTickets + " tickets cancelled");
    	}
    	else {
    		System.out.println("not more tickets can be cancelled than booked ");
    	}
    }
    public int getAvailableNoOfTickets() {
        return event.getAvailable_seats();
    }
    public void geteventdetails() {
    	if(event != null) {
    		event.displayeventdetails();
    	}else {
    		System.out.println("No events associated");
    	}
    }
    public void displaybookingdetails() {
    	System.out.println("BookingID" + bookingId);
    	System.out.println("Bookingdate" + bookingDate );
    	System.out.println("num of tickets" + numTickets );
    	System.out.println("totalcost" + totalCost);
    	geteventdetails();
    }
	public static int getBookingcounter() {
		return bookingcounter;
	}
	public static void setBookingcounter(int bookingcounter) {
		Booking.bookingcounter = bookingcounter;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getNumTickets() {
		return numTickets;
	}
	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
    
}
