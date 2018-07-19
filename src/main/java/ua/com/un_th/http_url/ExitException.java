package ua.com.un_th.http_url;

public class ExitException extends Exception{

	public ExitException() {
		super();
	}

	public ExitException(String message) {
		super(message);
	}

	public ExitException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExitException(Throwable cause) {
		super(cause);
	}
}
