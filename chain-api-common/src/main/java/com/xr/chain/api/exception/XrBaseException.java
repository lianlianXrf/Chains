package com.xr.chain.api.exception;

public class XrBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8414105338140596068L;

	public XrBaseException(String message) {
		super(message);
	}

	public XrBaseException(String message, Exception parent) {
		super(message, parent);
	}
}
