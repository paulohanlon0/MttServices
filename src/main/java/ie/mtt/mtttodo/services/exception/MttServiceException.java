package ie.mtt.mtttodo.services.exception;

public class MttServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MttServiceException() {
		super();
	}

	public MttServiceException(String message) {
		super(message);
	}

	public MttServiceException(Throwable cause) {
		super(cause);
	}

	public MttServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
