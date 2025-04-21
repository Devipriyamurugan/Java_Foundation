package com.hexaware.ims1.entity;

public class HomeLoan extends Loan{
	    private String propertyAddress;
	    private int propertyValue;
		public HomeLoan(int loanID, Customer customer, double principalAmount, double interestRate, int loanTerm,
				String loanType, String loanStatus, String propertyAddress, int propertyValue) {
			super(loanID, customer, principalAmount, interestRate, loanTerm, loanType, loanStatus);
			this.propertyAddress = propertyAddress;
			this.propertyValue = propertyValue;
		}
		public String getPropertyAddress() {
			return propertyAddress;
		}
		public void setPropertyAddress(String propertyAddress) {
			this.propertyAddress = propertyAddress;
		}
		public int getPropertyValue() {
			return propertyValue;
		}
		public void setPropertyValue(int propertyValue) {
			this.propertyValue = propertyValue;
		}
		


}
