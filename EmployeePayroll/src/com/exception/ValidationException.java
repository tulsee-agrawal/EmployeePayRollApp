/*
 *  CUSTOM EXCPTION
 *  
 *This class represents a validation-elated problem.
 *
 *Instead of stopping the program abruptlu,
 *we clearly communicate what went wrong.
 *
 */
package com.exception;


public class ValidationException extends Exception{
	public ValidationException(String message) {
		super(message);
	
	}
}
