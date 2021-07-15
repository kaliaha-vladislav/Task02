package by.company.kaliaha.util;

@SuppressWarnings("serial")
public class IncorrectBallDataException extends Exception {

	public IncorrectBallDataException () {
		super();
	}
	
	public IncorrectBallDataException (String message) {
		super(message);
	}
	
	public IncorrectBallDataException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public IncorrectBallDataException (Throwable cause) {
		super(cause);
	}
}