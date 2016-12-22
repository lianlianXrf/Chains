package com.xr.chain.api.exception;

public class XrDeployException extends XrBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2202771409129918014L;

	public XrDeployException(String message) {
		super(message);
	}

	public XrDeployException(String message, Exception parent) {
		super(message, parent);
	}
}
