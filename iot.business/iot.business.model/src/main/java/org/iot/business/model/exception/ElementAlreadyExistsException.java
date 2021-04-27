/**
 * 
 */
package org.iot.business.model.exception;

/**
 * @author loboo
 *
 */
public class ElementAlreadyExistsException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2301357911994469660L;
	/**
	 * 
	 */
	
	private String message;
	private String error; 
	
	public ElementAlreadyExistsException(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}
	
	public ElementAlreadyExistsException(String message) {
		super();
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
	
	

}
