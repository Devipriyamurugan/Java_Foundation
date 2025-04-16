package Entity;

public abstract class Loan {
	private int LoanID;
	private Customer customer;
	private double principalAmount;
	private double InterestRate;
	private int LoanTerm; //in months
	private String LoanType;
	private String loanStatus;
	
	public Loan() {
		
	}

	public Loan(int loanID, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus) {
		this.LoanID = loanID;
		this.customer = customer;
		this.principalAmount = principalAmount;
		this.InterestRate = interestRate;
		this.LoanTerm = loanTerm;
		this.LoanType = loanType;
		this.loanStatus = loanStatus;
	}

	public int getLoanID() {
		return LoanID;
	}

	public void setLoanID(int loanID) {
		LoanID = loanID;
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

	public void setPrincipalAmount(int principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(int interestRate) {
		InterestRate = interestRate;
	}

	public int getLoanTerm() {
		return LoanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		LoanTerm = loanTerm;
	}

	public String getLoanType() {
		return LoanType;
	}

	public void setLoanType(String loanType) {
		LoanType = loanType;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	

}
