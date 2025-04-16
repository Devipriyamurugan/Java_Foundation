package dao;
import java.util.List;

import Entity.Loan; 
import exception.InvalidLoanException;

public interface ILoanRepository {
	boolean applyLoan(Loan loan);
	double calculateInterest(int LoanID ) throws InvalidLoanException;
	double calculateInterest(double principal , double rate , int term);
	double calculateemi(int LoanID) throws InvalidLoanException;
	double calculateemi(double principal , double rate , int term);
	void loanRepayment(int loanId, double amount) throws InvalidLoanException;
	List<Loan> getAllLoan();
	Loan getLoanByID (int LoadID) throws InvalidLoanException;
	
	

}
