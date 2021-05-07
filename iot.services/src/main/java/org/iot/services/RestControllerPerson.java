/**
 * 
 */
package org.iot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.iot.services.model.PersonRequest;

/**
 * @author loboo
 *
 */
public interface RestControllerPerson {
	
	public ResponseEntity<?> obtener () throws Exception;;
	
	public ResponseEntity<?> crear (@RequestBody PersonRequest p) throws Exception;
	
	public ResponseEntity<?> modificar (@RequestBody PersonRequest p, @PathVariable("id_persona") Integer id) throws Exception;
	
	public ResponseEntity<?> eliminar (@PathVariable("id") Integer id) throws Exception;

}
