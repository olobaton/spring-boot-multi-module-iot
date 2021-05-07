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
	private Class<?> clazz;
	
	public ElementAlreadyExistsException(String message, String error, Class<?> clazz) {
		super();
		this.message = message;
		this.error = error;
		this.clazz = clazz;
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

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	

}
