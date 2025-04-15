package Task7.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Task4.Customer;
import Task4.Event;
import Task4.Venue;
import Task5.Concert;
import Task5.Movie;
import Task5.Sports;
import Task7.service.*;
import Task9.EventNotFoundException;
public class ticketbookingsysmthd {
	public static void main(String[] args) throws EventNotFoundException {
        Scanner sc = new Scanner(System.in);
        Bookingsystem system = new Bookingsystem();
        while (true) {
            System.out.println("\n1. Create Event\n2. List Events\n3. Book Tickets\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            case 1:
                System.out.print("Enter Event Type (movie/concert/sport): ");
                String event_type = sc.nextLine();
                System.out.print("Event Name: ");
                String eventname = sc.nextLine();
                System.out.print("Date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.print("Time (HH:MM): ");
                LocalTime time = LocalTime.parse(sc.nextLine());
                System.out.print("Venue Name: ");
                String vname = sc.nextLine();
                System.out.print("Venue Address: ");
                String vaddr = sc.nextLine();
                System.out.print("Total Seats: ");
                int total_seats = sc.nextInt();
                System.out.print("Ticket Price: ");
                double ticketprice = sc.nextDouble();
                sc.nextLine();

                Venue venue = new Venue(vname, vaddr);
                Event event = null;
                if (event_type.equalsIgnoreCase("movie")) {
                    event = new Movie(eventname, date, time, venue, total_seats, ticketprice, "Action", "Hero", "Heroine");
                }
                else if(event_type.equalsIgnoreCase("concert")) {
                	event = new Concert(eventname , date , time , venue , total_seats , ticketprice, "Artist", "concerttype" );
                }
                else if(event_type.equalsIgnoreCase("sports")) {
                	event = new Sports(eventname , date , time , venue , total_seats , ticketprice, "name", "Team" );
                }
                else {
                	throw new EventNotFoundException("Event type " + event_type + " not available" );
                }
                break;
            case 2:
                system.listEvents();
                break;
            case 3:
                System.out.print("Enter Event Name: ");
                String ename = sc.nextLine();

                System.out.print("How many tickets? ");
                int ntickets = sc.nextInt(); sc.nextLine();
                List<Customer> customers = new ArrayList<>();
                for (int i = 0; i < ntickets; i++) {
                    System.out.println("Customer " + (i + 1));
                    System.out.print("Name: "); String cname = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    customers.add(new Customer(cname, email, phone)); 
                }
                system.booktickets(ename, customers);
                break;
            case 4:
                System.out.println("Exiting system.");
                return;
            }
	}
	

}
}
