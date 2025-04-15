package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Task4.Event;
import Task4.Venue;
import Task4.Booking;
import Task4.Customer;
public class jdbcdemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbookingsystem1", "root", "Maruvar@27");
			System.out.println("connected");
			Statement stmt = conn.createStatement();
			String query = "Select * from Customer_Table";
			ResultSet  rs =	stmt.executeQuery(query);
			while(rs.next()){
				int customer_id= rs.getInt("customer_id");
				String customer_name = rs.getString("customer_name");
				String email=rs.getString("email");
				int phone_number = rs.getInt("phone_number");
				int booking_id = rs.getInt("booking_id");
				System.out.println(customer_id + " " + customer_name + " " + email + " " + phone_number + " " + booking_id);
			}
			Customer customer = new Customer();
			Venue venue = new Venue();
			Booking booking = new Booking();
			
		}catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private static void While(boolean next) {
		// TODO Auto-generated method stub
		
	}

}
