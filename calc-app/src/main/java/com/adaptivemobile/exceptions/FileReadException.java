package com.adaptivemobile.exceptions;

import java.io.FileNotFoundException;

public class FileReadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileReadException(String msg, FileNotFoundException e) {
		super(msg+"\n"+e.toString());
	}

}
