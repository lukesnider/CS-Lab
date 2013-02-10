
public class MaxDataException extends Exception {
	
	public MaxDataException() {
		super("Larger than Maximum Data Point:");
	}
	
	public MaxDataException(String message) {
		super(message);
	}

}
