package Task8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Task4.Booking;
import Task4.Customer;
import Task4.Event;
import Task4.Venue;

public class BookingSystemmain {
	public static void main(String[] args) {
		BookingSystemserviceproviderimpl service = new BookingSystemserviceproviderimpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
        	System.out.println("\n--- Ticket Booking Menu ---");
            System.out.println("1. Create Event\n2. View Events\n3. Book Tickets\n4. Cancel Booking\n5. Exit");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
            case 1:
                System.out.print("Enter event name: ");
                String name = sc.nextLine();
                System.out.print("Enter venue name: ");
                String vname = sc.nextLine();
                System.out.print("Enter venue address: ");
                String vaddr = sc.nextLine();
                Venue venue = new Venue(vname, vaddr);
                Event e = service.create_event(name, LocalDate.now(), LocalTime.now(), venue,50, 100.0, "movie");
                System.out.println("Event Created:");
                e.displayeventdetails();
                break;
            case 2:
                for (Event ev : service.getEventDetails()) {
                    ev.displayeventdetails();
                }
                break;
            case 3:
                System.out.print("Enter event name: ");
                String ename = sc.nextLine();
                List<Customer> custList = new ArrayList<>();
                System.out.print("Number of tickets: ");
                int num = sc.nextInt(); sc.nextLine();
                for (int i = 0; i < num; i++) {
                    System.out.print("Customer name: ");
                    String cname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    custList.add(new Customer(cname, email, phone));
                }
                Booking booking = service.bookTickets(ename, custList);
                if (booking != null) booking.displaybookingdetails();
                else System.out.println("Event not found.");
                break;
            case 4:
                System.out.print("Enter booking ID: ");
                int bid = sc.nextInt();
                service.cancelbooking(bid);
                break;
            case 5:
                System.exit(0);
            }
        }
	}

}
