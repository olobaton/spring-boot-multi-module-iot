/**
 * 
 */
package org.iot.business.model.exception;

/**
 * @author loboo
 *
 */
public class NoSuchElementFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private String message;
	private String error; 
	
	public NoSuchElementFoundException(String message, String error) {
		this.message = message;
		this.error = error;
	}
	
	public NoSuchElementFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
