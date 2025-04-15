package Task4;

public class Venue {
	private String venue_name;
	private String address;

public Venue() {
	
}
public Venue(String venue_name , String address) {
	this.venue_name=venue_name;
	this.address=address;
}
public String getVenue_name() {
	return venue_name;
}
public void setVenue_name(String venue_name) {
	this.venue_name = venue_name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public void displayvenuedetails() {
	System.out.println("Venue_name" + venue_name);
	System.out.println("address" + address);
}
}


