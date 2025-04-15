package Task5;

import java.time.LocalDate;
import java.time.LocalTime;

import Task4.Event;
import Task4.Venue;

public class Movie extends Task4.Event{
	private String genre;
    private String actorName;
    private String actressName;
    
    public Movie (String eventname, LocalDate date, LocalTime time, Venue venue, int total_seats, double ticketprice,  String genre, String actorName, String actressName) {
        super(eventname, date, time, venue, total_seats , ticketprice ,   "Movie");
        this.genre = genre;
        this.actorName = actorName;
        this.actressName = actressName;
    }

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	@Override
	public void displayeventdetails() {
		System.out.println("Genre " + genre );
		System.out.println("Movie " + getEventname());
		System.out.println("Actors: " + actorName + " ," + actressName );
	}
	
}
