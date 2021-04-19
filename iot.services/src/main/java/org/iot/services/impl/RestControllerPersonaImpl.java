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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.iot.business.logic.LogicPersona;
import org.iot.business.model.logic.LogicPersonaDTO;
import org.iot.services.ResControllerPersona;
import org.iot.services.model.ResPersona;

/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/persona")
public class RestControllerPersonaImpl implements ResControllerPersona {
	
	
	@Autowired
	LogicPersona logicpersona;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@GetMapping()
	public ResponseEntity<?> obtener () {		
		List<LogicPersonaDTO> logicpersonapo = null;
		List<ResPersona> restpersonapo = new ArrayList<ResPersona>();		
		logicpersonapo = logicpersona.findAll();
		if (logicpersonapo != null && logicpersonapo.size() != 0) {
			for(LogicPersonaDTO obj: logicpersonapo) {
				ResPersona rest = new ResPersona();
				rest.setId(obj.getId());
				rest.setNombre(obj.getNombre());
				rest.setUsuario(obj.getUsuario());
				rest.setPassword(obj.getPassword());
				restpersonapo.add(rest);		
			}			
		}		
		return new ResponseEntity<>(restpersonapo, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> crear (@RequestBody ResPersona p) {
		ResPersona restpersonapo = new ResPersona();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setNombre(p.getNombre());	
		logicpersonapo.setUsuario(p.getUsuario());
		logicpersonapo.setPassword(bcrypt.encode(p.getPassword()));
		logicpersonapo = logicpersona.save(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
		}	
		return new ResponseEntity<>(restpersonapo, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id_personar}")
	public ResponseEntity<?> modificar (@RequestBody ResPersona p, @PathVariable("id_personar") Integer id) {
		ResPersona restpersonapo = new ResPersona();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();
		
		logicpersonapo.setId(id);
		logicpersonapo.setNombre(p.getNombre());		
		logicpersonapo = logicpersona.modificar(logicpersonapo);
		if (logicpersonapo != null) {
			restpersonapo.setId(logicpersonapo.getId());
			restpersonapo.setNombre(logicpersonapo.getNombre());
		}		
		return new ResponseEntity<>(restpersonapo, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> eliminar (@PathVariable("id") Integer id) {
		logicpersona.eliminar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
