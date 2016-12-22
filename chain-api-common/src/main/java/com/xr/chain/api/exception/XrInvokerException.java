package com.xr.chain.api.exception;

public class XrInvokerException extends XrBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7074464691894401682L;

	public XrInvokerException(String message) {
		super(message);
	}

	public XrInvokerException(String message, Exception parent) {
		super(message, parent);
	}
}
