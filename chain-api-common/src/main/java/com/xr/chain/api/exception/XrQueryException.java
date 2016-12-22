package com.xr.chain.api.exception;

public class XrQueryException extends XrBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003211216214885352L;

	public XrQueryException(String message) {
		super(message);
	}

	public XrQueryException(String message, Exception parent) {
		super(message, parent);
	}
}
