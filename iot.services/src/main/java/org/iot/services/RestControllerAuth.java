/**
 * 
 */
package org.iot.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


import org.iot.services.model.UserRequest;

/**
 * @author loboo
 *
 */
public interface RestControllerAuth {
	
	public ResponseEntity<?> auth (@RequestBody UserRequest p) throws Exception;

}
