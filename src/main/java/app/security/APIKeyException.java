package app.security;

/**
 * The Class APIKeyException.
 */
public class APIKeyException extends RuntimeException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new API key exception.
	 *
	 * @param msg the msg
	 */
	public APIKeyException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new API key exception.
	 *
	 * @param msg the msg
	 * @param t the t
	 */
	public APIKeyException(String msg, Throwable t) {
		super(msg, t);
	}
}
