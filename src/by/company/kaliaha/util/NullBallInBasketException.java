package by.company.kaliaha.util;

@SuppressWarnings("serial")
public class NullBallInBasketException extends Exception {

	public NullBallInBasketException () {
		super();
	}
	
	public NullBallInBasketException (String message) {
		super(message);
	}
	
	public NullBallInBasketException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public NullBallInBasketException (Throwable cause) {
		super(cause);
	}
}