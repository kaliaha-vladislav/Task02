package by.company.kaliaha.util;

@SuppressWarnings("serial")
public class IncorrectObjectArgumentException extends Exception {

	public IncorrectObjectArgumentException () {
		super();
	}
	
	public IncorrectObjectArgumentException (String message) {
		super(message);
	}
	
	public IncorrectObjectArgumentException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public IncorrectObjectArgumentException (Throwable cause) {
		super(cause);
	}
}