package com.adaptivemobile.exceptions;


public class InvalidNumberException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public InvalidNumberException(String msg, NumberFormatException e) {
		super(msg+"\n"+e.toString());
	}
}
