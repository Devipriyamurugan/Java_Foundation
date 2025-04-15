package Task5;
import Task4.Customer;
import Task4.Booking;
import Task4.Venue;
import Task4.Event;
import Task5.Sports;
import Task5.Concert;
import Task5.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class mainmethod {
	public static Event create_event(String eventType, Scanner sc) {
        System.out.print("Enter event name: ");
        String eventname = sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = sc.next();
        LocalDate localDate = LocalDate.parse(date , formatter);
        System.out.print("Enter time: ");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH.mm.ss.nnn");
        String time = sc.next(); 
        LocalTime localTimeobj = LocalTime.parse(time , formatter1); 
        System.out.print("Enter venue name: ");
        String venue = sc.next();
        System.out.print("Enter venue address: ");
        String venue_address = sc.next();
        Venue venueObj = new Venue( venue, venue_address );
        System.out.print("Enter total seats: ");
        int total_seats = Integer.parseInt(sc.nextLine());
        System.out.print("Enter ticket price: ");
        double ticketprice = Double.parseDouble(sc.nextLine());
        switch (eventType.toLowerCase()) {
        case "movie":
            System.out.print("Enter genre: ");
            String genre = sc.nextLine();
            System.out.print("Enter actor name: ");
            String actor = sc.nextLine();
            System.out.print("Enter actress name: ");
            String actress = sc.nextLine();
            return new Movie(eventname, localDate, localTimeobj, venueObj , total_seats, ticketprice, genre, actor, actress);
        case "concert":
            System.out.print("Enter artist name: ");
            String artist = sc.nextLine();
            System.out.print("Enter concert type: ");
            String type = sc.nextLine();
            return new Concert(eventname, localDate, localTimeobj, venueObj, total_seats, ticketprice, artist, type);
        case "sports":
            System.out.print("Enter sport name: ");
            String sport = sc.nextLine();
            System.out.print("Enter teams (e.g., India vs Pakistan): ");
            String teams = sc.nextLine();
            return new Sports(eventname, localDate, localTimeobj, venueObj, total_seats, ticketprice, sport, teams);
        default:
            System.out.println("Invalid event type.");
            return null;
        }
	}
	public static void display_event_details(Event event) {
        event.displayeventdetails();
	}
	public static double book_tickets(Event event, int numTickets) {
        if (event.getAvailable_seats() >= numTickets) {
        	event.setAvailable_seats(event.getAvailable_seats() - numTickets);
            return numTickets * event.getTicketprice();
        } else {
            System.out.println("Sorry, not enough tickets available.");
            return 0;
        }
    }
	public static void cancel_tickets(Event event, int numTickets) {
        event.setAvailable_seats(event.getAvailable_seats()+ numTickets);
        System.out.println("Cancelled " + numTickets + " tickets successfully.");
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Event currentEvent = null;

        while (true) {
            System.out.println("\n--- Ticket Booking System ---");
            System.out.println("1. Create Event");
            System.out.println("2. Display Event Details");
            System.out.println("3. Book Tickets");
            System.out.println("4. Cancel Tickets");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter event type (Movie/Sports/Concert): ");
                    String type = sc.nextLine();
                    currentEvent = create_event(type, sc);
                    break;

                case 2:
                    if (currentEvent != null)
                        display_event_details(currentEvent);
                    else
                        System.out.println("No event created yet.");
                    break;

                case 3:
                    if (currentEvent != null) {
                        System.out.print("Enter number of tickets to book: ");
                        int num = Integer.parseInt(sc.nextLine());
                        double cost = book_tickets(currentEvent, num);
                        if (cost > 0)
                            System.out.println("Booking successful. Total cost: $" + cost);
                    } else {
                        System.out.println("No event created yet.");
                    }
                    break;

                case 4:
                    if (currentEvent != null) {
                        System.out.print("Enter number of tickets to cancel: ");
                        int cancel = Integer.parseInt(sc.nextLine());
                        cancel_tickets(currentEvent, cancel);
                    } else {
                        System.out.println("No event created yet.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
	}
}
