package Task8;
import java.util.List;

import Task4.Booking;
import Task4.Customer;

public interface IBookingsystemserviceprovider {
	Booking bookTickets(String eventName, List<Customer> customers);
	void cancelbooking(int bookingId);
	Booking getbookingdetails(int bookingId);
	
	

}
