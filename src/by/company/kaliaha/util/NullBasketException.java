package by.company.kaliaha.util;

@SuppressWarnings("serial")
public class NullBasketException extends Exception {

	public NullBasketException () {
		super();
	}
	
	public NullBasketException (String message) {
		super(message);
	}
	
	public NullBasketException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public NullBasketException (Throwable cause) {
		super(cause);
	}
}