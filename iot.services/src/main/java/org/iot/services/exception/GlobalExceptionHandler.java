/**
 * 
 */
package org.iot.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.iot.business.model.exception.NoSuchElementFoundException;

import java.util.Date;

import org.iot.business.model.exception.ErrorDetails;

/**
 * @author loboo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(NoSuchElementFoundException exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value()
						, exception.getMessage() , exception.getError() ,  request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling specific exception
	@ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
	      HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<?> badrequest(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), HttpStatus.BAD_REQUEST.value()
						, HttpStatus.BAD_REQUEST.getReasonPhrase() , exception.getMessage() ,  request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value()
						, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() , exception.getMessage() ,  request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
