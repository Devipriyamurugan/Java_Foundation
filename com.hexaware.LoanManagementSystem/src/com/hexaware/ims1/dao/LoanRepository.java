package com.hexaware.ims1.dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import com.hexaware.ims1.entity.Loan;
import com.hexaware.ims1.util.DBUtil;

	public class LoanRepository implements ILoanRepository {
	    private Connection connection;

	    public LoanRepository() {
	        this.connection = DBUtil.getDBConn();
	    }

	    @Override
	    public void applyLoan(Loan loan) throws SQLException {
	        String sql = "INSERT INTO Loan (CustomerID, PrincipalAmount, InterestRate, LoanTerm, LoanType, LoanStatus) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, loan.getCustomer().getCustomerID());
	            stmt.setDouble(2, loan.getPrincipalAmount());
	            stmt.setDouble(3, loan.getInterestRate());
	            stmt.setInt(4, loan.getLoanTerm());
	            stmt.setString(5, loan.getLoanType());
	            stmt.setString(6, loan.getLoanStatus());
	            stmt.executeUpdate();
	        }
	    }

	    @Override
	    public double calculateInterest(int loanID) throws SQLException {
	        String sql = "SELECT PrincipalAmount, InterestRate, LoanTerm FROM Loan WHERE LoanID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, loanID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                double principal = rs.getDouble("PrincipalAmount");
	                double rate = rs.getDouble("InterestRate");
	                int term = rs.getInt("LoanTerm");
	                return (principal * rate * term) / 12;
	            }
	        }
	        return 0;
	    }

	    @Override
	    public double calculateInterest(double principalAmount, double interestRate, int loanTerm) {
	        return (principalAmount * interestRate * loanTerm) / 12;
	    }

	    @Override
	    public void loanStatus(int loanID) throws SQLException {
	        String sql = "SELECT CreditScore FROM Customer WHERE CustomerID = (SELECT CustomerID FROM Loan WHERE LoanID = ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, loanID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int creditScore = rs.getInt("CreditScore");
	                String status = creditScore > 650 ? "Approved" : "Rejected";
	                updateLoanStatus(loanID, status);
	            }
	        }
	    }

	    private void updateLoanStatus(int loanID, String status) throws SQLException {
	        String sql = "UPDATE Loan SET LoanStatus = ? WHERE LoanID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, status);
	            stmt.setInt(2, loanID);
	            stmt.executeUpdate();
	        }
	    }

	    @Override
	    public double calculateEMI(int loanID) throws SQLException {
	        String sql = "SELECT PrincipalAmount, InterestRate, LoanTerm FROM Loan WHERE LoanID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, loanID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                double principal = rs.getDouble("PrincipalAmount");
	                double rate = rs.getDouble("InterestRate") / 12 / 100;
	                int term = rs.getInt("LoanTerm");
	                return (principal * rate * Math.pow(1 + rate, term)) / (Math.pow(1 + rate, term) - 1);
	            }
	        }
	        return 0;
	    }

	    @Override
	    public double calculateEMI(double principalAmount, double interestRate, int loanTerm) {
	        double rate = interestRate / 12 / 100;
	        return (principalAmount * rate * Math.pow(1 + rate, loanTerm)) / (Math.pow(1 + rate, loanTerm) - 1);
	    }

	    @Override
	    public void loanRepayment(int loanID, double amount) throws SQLException {
	        double emi = calculateEMI(loanID);
	        if (amount >= emi) {
	            String sql = "UPDATE Loan SET PrincipalAmount = PrincipalAmount - ? WHERE LoanID = ?";
	            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	                stmt.setDouble(1, amount);
	                stmt.setInt(2, loanID);
	                stmt.executeUpdate();
	            }
	        }
	    }

	    @Override
	    public List<Loan> getAllLoans() throws SQLException {
	        List<Loan> loans = new ArrayList<>();
	        String sql = "SELECT * FROM Loan";
	        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Loan loan = new Loan();
	                loan.setLoanID(rs.getInt("LoanID"));
	                loan.setPrincipalAmount(rs.getDouble("PrincipalAmount"));
	                loan.setInterestRate(rs.getDouble("InterestRate"));
	                loan.setLoanTerm(rs.getInt("LoanTerm"));
	                loan.setLoanType(rs.getString("LoanType"));
	                loan.setLoanStatus(rs.getString("LoanStatus"));
	                loans.add(loan);
	            }
	        }
	        return loans;
	    }

	    @Override
	    public Loan getLoanById(int loanID) throws SQLException {
	        String sql = "SELECT * FROM Loan WHERE LoanID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, loanID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                Loan loan = new Loan();
	                loan.setLoanID(rs.getInt("LoanID"));
	                loan.setPrincipalAmount(rs.getDouble("PrincipalAmount"));
	                loan.setInterestRate(rs.getDouble("InterestRate"));
	                loan.setLoanTerm(rs.getInt("LoanTerm"));
	                loan.setLoanType(rs.getString("LoanType"));
	                loan.setLoanStatus(rs.getString("LoanStatus"));
	                return loan;
	            }
	        }
	        return null;
	    }
	}



