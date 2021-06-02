/**
 * 
 */
package org.iot.services;

import org.iot.business.model.exception.WebException;
import org.iot.services.model.request.PersonalDataRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author loboo
 *
 */
public interface RestControllerPerson {
	
	public ResponseEntity<?> getAll () throws WebException;;
	
	public ResponseEntity<?> save (@RequestBody PersonalDataRequestDTO p) throws WebException;
	
	public ResponseEntity<?> modify (@RequestBody PersonalDataRequestDTO p, @PathVariable("id_persona") Integer id) throws WebException;
	
	public ResponseEntity<?> delete (@PathVariable("id") Integer id) throws WebException;

}
