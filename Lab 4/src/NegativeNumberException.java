
public class NegativeNumberException extends Exception {
	
	public NegativeNumberException() {
		super("Negative number... No Bueno");
	}
	
	public NegativeNumberException(String message) {
		super(message);
	}

}
