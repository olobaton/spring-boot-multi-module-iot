/**
 * 
 */
package org.iot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iot.business.logic.LogicPersona;
import org.iot.business.model.logic.LogicPersonaDTO;
import org.iot.services.RestControllerPerson;
import org.iot.services.model.PersonRequest;
import org.iot.services.model.PersonResponse;

/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/persona")
@CrossOrigin
public class RestControllerPersonImpl implements RestControllerPerson {
		
	@Autowired
	LogicPersona logicpersona;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private static final Logger logger = LogManager.getLogger(RestControllerPersonImpl.class);
	
	@GetMapping()
	public ResponseEntity<?> obtener ()  throws Exception {	
		
		logger.info("URL: /persona - GET - Method get");
		List<LogicPersonaDTO> logicpersonapo = null;
		List<PersonResponse> restpersonapo = new ArrayList<PersonResponse>();		
		logicpersonapo = logicpersona.findAll();
		if (logicpersonapo != null && logicpersonapo.size() != 0) {
			for(LogicPersonaDTO obj: logicpersonapo) {
				PersonResponse rest = new PersonResponse();
				rest.setId(obj.getId());
				rest.setNombre(obj.getNombre());
				rest.setUsuario(obj.getUsuario());
				restpersonapo.add(rest);		
			}			
		}		
		return new ResponseEntity<>(restpersonapo, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> crear (@RequestBody PersonRequest p) throws Exception {
		logger.info("URL: /persona - POST - Method save // @RequestBody");
		
		PersonResponse restpersonapo = new PersonResponse();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setNombre(p.getNombre());	
		logicpersonapo.setUsuario(p.getUsuario());
		logicpersonapo.setPassword(bcrypt.encode(p.getPassword()));
		logicpersonapo = logicpersona.save(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
			restpersonapo.setUsuario(logicpersonapo.getUsuario());
		}	
		return new ResponseEntity<>(restpersonapo, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id_personar}")
	public ResponseEntity<?> modificar (@RequestBody PersonRequest p, @PathVariable("id_personar") Integer id) throws Exception {
		logger.info("URL: /persona - PUT - Method modify // @RequestBody");
		PersonResponse restpersonapo = new PersonResponse();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setId(id);
		logicpersonapo.setNombre(p.getNombre());		
		logicpersonapo.setUsuario(p.getUsuario());
		logicpersonapo = logicpersona.modificar(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
			restpersonapo.setUsuario(logicpersonapo.getUsuario());
		}		
		return new ResponseEntity<>(restpersonapo, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminar (@PathVariable("id") Integer id) throws Exception {
		logger.info("URL: /persona - DELETE - Method delete");
		logicpersona.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
