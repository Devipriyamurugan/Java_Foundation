package Task5;
import Task4.*;

import java.time.LocalDate;
import java.time.LocalTime;

import Task4.Event;

public class Sports extends Task4.Event {
	private String sportName;
    private String teamsName;
    
    public Sports(String eventname, LocalDate event_date, LocalTime event_time, Venue venue, int total_seats, double ticketprice , String sportName ,String teamsName) {
    	super(eventname, event_date, event_time, venue, total_seats, ticketprice, "Sports");
        this.sportName = sportName;
        this.teamsName = teamsName;
    	
    }
    @Override
    public void displayeventdetails() {
    	System.out.println("SportsName " + getEventname() );
    	System.out.println("sport " + sportName);
    	System.out.println("Match " + teamsName);
    }
    
	

}
