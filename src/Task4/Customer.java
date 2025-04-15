package Task4;

public class Customer {
	private String Customer_name;
	private String email;
	private String phonenumber;
	public Customer() {
		
	}
	public Customer(String Customer_name , String email , String phonenumber) {
		this.Customer_name=Customer_name;
		this.email=email;
		this.phonenumber=phonenumber;
	}
	public void displaycustomerdetails() {
		System.out.println("CustomerName" + Customer_name);
		System.out.println("email" + email);
		System.out.println("phonenumber" + phonenumber);
		
		
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	

}
