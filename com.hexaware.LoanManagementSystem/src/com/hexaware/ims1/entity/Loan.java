package com.hexaware.ims1.entity;

public class Loan {
	    private int loanID;
	    private Customer customer;
	    private double principalAmount;
	    private double interestRate;
	    private int loanTerm;
	    private String loanType;
	    private String loanStatus;
		public Loan(int loanID, Customer customer, double principalAmount, double interestRate, int loanTerm,
				String loanType, String loanStatus) {
			super();
			this.loanID = loanID;
			this.customer = customer;
			this.principalAmount = principalAmount;
			this.interestRate = interestRate;
			this.loanTerm = loanTerm;
			this.loanType = loanType;
			this.loanStatus = loanStatus;
		}
		public Loan( int customerId, double principalAmount, double interestRate, int loanTerm, String loanType, String status )
		{
			Customer customerObj = new Customer(customerId);
			this.customer =customerObj;
			this.interestRate = interestRate;
			this.loanStatus = status;
			this.loanTerm = loanTerm;
			this.principalAmount = principalAmount;
		}
		public Loan() {
			// TODO Auto-generated constructor stub
		}
		public int getLoanID() {
			return loanID;
		}
		public void setLoanID(int loanID) {
			this.loanID = loanID;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public double getPrincipalAmount() {
			return principalAmount;
		}
		public void setPrincipalAmount(double principalAmount) {
			this.principalAmount = principalAmount;
		}
		public double getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}
		public int getLoanTerm() {
			return loanTerm;
		}
		public void setLoanTerm(int loanTerm) {
			this.loanTerm = loanTerm;
		}
		public String getLoanType() {
			return loanType;
		}
		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}
		public String getLoanStatus() {
			return loanStatus;
		}
		public void setLoanStatus(String loanStatus) {
			this.loanStatus = loanStatus;
		}
		

}
