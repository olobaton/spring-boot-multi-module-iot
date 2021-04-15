/**
 * 
 */
package org.iot.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.iot.services.model.ResPersona;

/**
 * @author loboo
 *
 */
public interface ResControllerPersona {
	
	public ResponseEntity<?> obtener ();
	
	public ResponseEntity<?> crear (@RequestBody ResPersona p);
	
	public ResponseEntity<?> modificar (@RequestBody ResPersona p, @PathVariable("id_persona") Integer id);
	
	public ResponseEntity<?> eliminar (@PathVariable("id") Integer id);

}
