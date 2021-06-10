/**
 * 
 */
package org.iot.business.model.exception;

/**
 * @author loboo
 *
 */
public class BodyRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2578196906056911955L;
	private String message;
	private String error; 
	private Class<?> clazz;
		
	public BodyRequestException(String message, String error, Class<?> clazz) {
		super();
		this.message = message;
		this.error = error;
		this.clazz = clazz;
	}
	
	public BodyRequestException(String message) {
		super();
		this.message = message;
	}
	
	public BodyRequestException() {
		super();
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
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	

}
