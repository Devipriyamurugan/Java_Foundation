package Entity;

public class Customer {
	private int CustomerID;
	private String Name;
	private String emailaddress;
	private int phonenumber;
	private String address;
	private int creditscore;
	
	public Customer() {
		
	}
	public Customer(int CustomerID , String Name , String emailaddress , int phonenumber , String address , int creditscore ) {
		this.CustomerID=CustomerID;
		this.Name = Name;
		this.emailaddress=emailaddress;
		this.phonenumber=phonenumber;
		this.address=address;
		this.creditscore=creditscore;
		
		
	}
	public Customer(int CustomerID)
	{
		this.CustomerID = CustomerID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	
	

}
