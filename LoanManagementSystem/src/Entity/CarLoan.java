package Entity;

public class CarLoan extends Loan {
	private String carmodel;
	private int carvalue;
	
	public CarLoan() {
		
	}
	
	public CarLoan(int loanID, Customer customer, double principalAmount, double interestRate, int loanTerm, String loanType,
			String loanStatus , String carmodel , int carvalue) {
		super(loanID , customer , principalAmount , interestRate , loanTerm , loanType , loanStatus );
		this.carmodel=carmodel;
		this.carvalue=carvalue;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public int getCarvalue() {
		return carvalue;
	}

	public void setCarvalue(int carvalue) {
		this.carvalue = carvalue;
	}
	

}
