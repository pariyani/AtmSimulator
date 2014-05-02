package com.pariyani.exception;


/**
 * XXX put some useful doc here.
 * 
 * @author imran
 */
public class InsufficientFundsException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -1652996927909590834L;

	public InsufficientFundsException() {
		super();
	}

	public InsufficientFundsException(final String message) {
		super(message);
	}

	public InsufficientFundsException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InsufficientFundsException(final Throwable cause) {
		super(cause);
	}

}
