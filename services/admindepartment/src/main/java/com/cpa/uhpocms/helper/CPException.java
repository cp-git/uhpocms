package com.cpa.uhpocms.helper;


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

	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return message;
	}
}