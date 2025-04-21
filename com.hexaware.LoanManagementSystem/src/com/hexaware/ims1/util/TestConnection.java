package com.hexaware.ims1.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


	public class TestConnection {
	    public static void main(String[] args) {
	        try (Connection conn = DBUtil.getDBConn()) {
	            if (conn != null) {
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery("SELECT DATABASE()");
	                if (rs.next()) {
	                    System.out.println("Connected to database: " + rs.getString(1));
	                }
	            } else {
	                System.out.println("Failed to make connection!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}


