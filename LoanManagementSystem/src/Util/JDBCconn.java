package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCconn {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "Maruvar@27");
			Statement stmt = conn.createStatement();
			String updateQuery = "update Customer set name = 'john' where CustomerID  = 1";
			int count = stmt.executeUpdate(updateQuery);
			System.out.println(count + " record effected...");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}