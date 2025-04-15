package Task5;
import Task4.*;
import java.time.LocalDate;
import java.time.LocalTime;

import Task4.Event;
import Task4.Venue;

public class Concert extends Task4.Event{
	    private String artist;
	    private String concertType;
	    
	    public Concert(String eventname, LocalDate event_date, LocalTime event_time, Venue venue, int total_seats, double ticketprice , String artist , String concertType )
	    {
	    	super(eventname, event_date, event_time, venue, total_seats, ticketprice, "Concert");
	    	this.artist = artist;
	        this.concertType = concertType;
	    }
	    
	    public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getConcertType() {
			return concertType;
		}

		public void setConcertType(String concertType) {
			this.concertType = concertType;
		}

		@Override
	    public void displayeventdetails() {
	    	System.out.println("Concert " + getEventname() );
	    	System.out.println("Artist " + artist );
	    	System.out.println("ConcertType " + concertType);
	    }
}
