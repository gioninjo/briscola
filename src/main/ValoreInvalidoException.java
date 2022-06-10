package main;

@SuppressWarnings("serial")
public class ValoreInvalidoException extends Exception {

	public ValoreInvalidoException() {
		super();
	}

	public ValoreInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValoreInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValoreInvalidoException(String message) {
		super(message);
	}

	public ValoreInvalidoException(Throwable cause) {
		super(cause);
	}

}