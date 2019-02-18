package com.vehicle.workshop.exception;

public class UnknownResourceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownResourceException(String msg) {
        super(msg);
    }

}
