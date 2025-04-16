package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Entity.*;
import exception.InvalidLoanException;

public class ILoanRepositoryimpl implements ILoanRepository {
	private Map<Integer, Loan> loanMap = new HashMap<>();
	
	@Override
	public boolean applyLoan(Loan loan) {
		Scanner sc = new Scanner(System.in);
		System.out.println("confirm apply loan for customer" + loan.getCustomer().getName() + " is (yes or no)" );
		String input = sc.nextLine();
		
		if(input.equalsIgnoreCase("yes")) {
			loan.setLoanStatus("Pending");
			loanMap.put(loan.getLoanID(), loan);
			System.out.println("Loan applied and saved with status 'Pending'");
			return true;
		}
		else {
			System.out.println("loan application canceled");
			return false;
		}
		
	}
	@Override
	public double calculateInterest(int LoanID ) throws InvalidLoanException{
		Loan loan = loanMap.get(LoanID);
		if (loan == null) throw new InvalidLoanException("Loan ID not found: " + LoanID);
		return calculateInterest(loan.getPrincipalAmount(), loan.getInterestRate(), loan.getLoanTerm());
	}
	
	@Override
	public double calculateInterest(double principal , double rate , int term) {
		return (principal*rate*term)/12;
	}
	
	@Override
	public double calculateemi(int LoanID) throws InvalidLoanException{
		Loan loan = loanMap.get(LoanID);
		if (loan == null) throw new InvalidLoanException("Loan ID not found: " + LoanID);
		return calculateemi(loan.getPrincipalAmount(),loan.getInterestRate(), loan.getLoanTerm());
		
	}
	@Override
	public double calculateemi(double principal , double rate , int term) {
		double monthlyrate = (rate / 12) / 100;
		return (principal * monthlyrate * Math.pow(1 + monthlyrate, term)) /
	               (Math.pow(1 + rate, term) - 1);
	}
	@Override
	public void loanRepayment(int LoanID , double amount) throws InvalidLoanException {
		Loan loan = loanMap.get(LoanID);
		if (loan == null) throw new InvalidLoanException("Loan ID not found: " + LoanID);
		double emi = calculateemi(loan.getPrincipalAmount(),loan.getInterestRate(), loan.getLoanTerm());
		if(amount>emi) {
			System.out.println("amount is less than one emi");
			return;
		}
		int paidemi=(int)(amount/emi);
		System.out.println("you have paid emis" + paidemi + " from this amount " + amount);
		
	}
	@Override
    public List<Loan> getAllLoan() {
        return new ArrayList<>(loanMap.values());
    }
	@Override
    public Loan getLoanByID(int LoanID) throws InvalidLoanException {
        Loan loan = loanMap.get(LoanID);
        if (loan == null) throw new InvalidLoanException("Loan ID not found: " + LoanID);
        return loan;
    }

	

}
