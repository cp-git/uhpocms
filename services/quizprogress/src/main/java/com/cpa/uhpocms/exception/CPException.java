package com.cpa.uhpocms.exception;

public class CPException extends Exception {
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String message;

	public CPException() {
		super();
	}

	public CPException(String code, String message) {
		this.errorCode = code;
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return errorCode + " - " + message;
	}

}
