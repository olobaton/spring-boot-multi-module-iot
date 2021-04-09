/**
 * 
 */
package org.iot.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


import org.iot.services.model.ResUsuario;

/**
 * @author loboo
 *
 */
public interface ResControllerUsuario {
	
	public ResponseEntity<?> auth (@RequestBody ResUsuario p) throws Exception;

}
