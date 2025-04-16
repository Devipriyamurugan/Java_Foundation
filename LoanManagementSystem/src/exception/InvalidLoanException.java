package exception;

public class InvalidLoanException extends Exception {
	public InvalidLoanException(String message) {
        super(message);
    }
	public InvalidLoanException() {
        super("Invalid loan operation or loan not found.");
    }

}
