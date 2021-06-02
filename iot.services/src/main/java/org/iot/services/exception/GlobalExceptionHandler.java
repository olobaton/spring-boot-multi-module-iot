/**
 * 
 */
package org.iot.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.exception.WebException;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.ErrorDetails;

/**
 * @author loboo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	// handling specific ElementAlreadyExistsException
	@ExceptionHandler(ElementAlreadyExistsException.class)
	public ResponseEntity<?> resourceAlreadyExistsHandling(ElementAlreadyExistsException exception,
			WebRequest request) {
		logger.warn(exception.getClazz().toString() + " - " + exception.getClass() + " - " + exception.getError()
				+ " - " + exception.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(), exception.getError(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

	// handling specific NoSuchElementFoundException
	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(NoSuchElementFoundException exception, WebRequest request) {
		logger.warn(exception.getClazz().toString() + " - " + exception.getClass() + " - " + exception.getError()
				+ " - " + exception.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getError(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling specific exception
	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
			HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<?> badrequest(Exception exception, WebRequest request) {
		logger.warn(exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// handling global ServiceException

	@ExceptionHandler(WebException.class)
	public ResponseEntity<?> globalExceptionHandling(WebException exception, WebRequest request) {
		logger.error(exception.getClazz().toString() + " - " + exception.getClass() + " - " + exception.getMessage()
				+ " - " + exception.getCause());
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
