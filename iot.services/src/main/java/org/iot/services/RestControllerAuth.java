/**
 * 
 */
package org.iot.services;

import org.iot.business.model.exception.WebException;
import org.iot.services.model.request.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author loboo
 *
 */
public interface RestControllerAuth {
	
	public ResponseEntity<?> auth (@RequestBody UserRequestDTO p) throws WebException;

}
