/**
 * 
 */
package org.iot.business.model.exception;

/**
 * @author loboo
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1741391262971799706L;
	private String message;
	private String error; 
	private Class<?> clazz;

	/**
	 * 
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Constructor sobrecargado con el mensaje personalizado
	 * 
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
		this.setMessage(message);
	}

	/**
	 * Constructor sobrecargado con el mensaje personalizado
	 * 
	 * @param message
	 */
	public ServiceException(String error, String message) {
		super(message);
		this.setError(error);
		this.setMessage(message);
	}

	/**
	 * Constructor sobrecargado con el mensaje personalizado y una causa u objeto
	 * throwable
	 * 
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		this.setMessage(message);
	}
	
	public ServiceException(String message, Throwable cause, Class<?> clazz) {
		super(message, cause);
		this.setMessage(message);
		this.setClazz(clazz);
	}

	/**
	 * Constructor sobrecargado con una causa u objeto throwable o lanzable
	 * 
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
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
