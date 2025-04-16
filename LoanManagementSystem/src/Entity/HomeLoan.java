package Entity;

public class HomeLoan extends Loan{
	private String propertyaddress;
	private int propertyvalue;
	
	public HomeLoan() {
		
	}
	
	public HomeLoan(int loanID, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus , String propertyaddress , int propertyvalue ) {
		 super(loanID , customer , principalAmount , interestRate , loanTerm , loanType, loanStatus );
		this.propertyaddress=propertyaddress;
		this.propertyvalue=propertyvalue;
		
	}

	public String getPropertyaddress() {
		return propertyaddress;
	}

	public void setPropertyaddress(String propertyaddress) {
		this.propertyaddress = propertyaddress;
	}

	public int getPropertyvalue() {
		return propertyvalue;
	}

	public void setPropertyvalue(int propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	
	
}
