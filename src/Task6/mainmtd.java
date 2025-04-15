package Task6;
import Task6.Event;

import java.time.LocalDate;
import java.time.LocalTime;

import Task4.Venue;

public class mainmtd {
	TicketBookingSys tbs = new TicketBookingSys();
	Venue venue = new Venue("INOX", "Mumbai");
	Task4.Event event = tbs.create_event("Batman", LocalDate.now(), LocalTime.now(), venue, 100, 400, "movie"); 


}
