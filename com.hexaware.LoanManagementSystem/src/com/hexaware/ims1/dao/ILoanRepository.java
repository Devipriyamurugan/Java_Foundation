package com.hexaware.ims1.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.ims1.entity.Loan;

public interface ILoanRepository {
	    void applyLoan(Loan loan) throws SQLException;
	    double calculateInterest(int loanID) throws SQLException;
	    double calculateInterest(double principalAmount, double interestRate, int loanTerm);
	    void loanStatus(int loanID) throws SQLException;
	    double calculateEMI(int loanID) throws SQLException;
	    double calculateEMI(double principalAmount, double interestRate, int loanTerm);
	    void loanRepayment(int loanID, double amount) throws SQLException;
	    List<Loan> getAllLoans() throws SQLException;
	    Loan getLoanById(int loanID) throws SQLException;
	

}
