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
import org.iot.business.logic.PersonalDataBo;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.exception.WebException;
import org.iot.business.model.logic.PersonalDataDTO;
import org.iot.business.model.logic.UserDTO;
import org.iot.services.RestControllerPerson;
import org.iot.services.mapper.PersonalDataMapperResponse;
import org.iot.services.model.request.PersonalDataRequestDTO;
import org.iot.services.model.response.PersonalDataResponseDTO;

/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/persona")
@CrossOrigin
public class RestControllerPersonImpl implements RestControllerPerson {
		
	@Autowired
	PersonalDataBo logicpersona;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private static final Logger logger = LogManager.getLogger(RestControllerPersonImpl.class);
	
	@GetMapping()
	public ResponseEntity<?> getAll ()  throws WebException {	
		
		logger.info("URL: /persona - GET - Method get");
		List<PersonalDataDTO> personaldatadto = null;
		List<PersonalDataResponseDTO> personaldataresponse = new ArrayList<PersonalDataResponseDTO>();		
		try {
			personaldatadto = logicpersona.findAll();
			if (personaldatadto != null && personaldatadto.size() != 0) {
				for(PersonalDataDTO obj: personaldatadto) {
					personaldataresponse.add(PersonalDataMapperResponse.INSTANCE.PersonalDataDTOToPersonalDataResponseDTO(obj));		
				}			
			}					
		} catch (ServiceException e) {
			throw new WebException(e.getMessage(), e.getCause() , e.getClazz());
		}
		return new ResponseEntity<>(personaldataresponse, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> save (@RequestBody PersonalDataRequestDTO personaldatarequest) throws WebException {
		logger.info("URL: /persona - POST - Method save // @RequestBody");
		
		PersonalDataResponseDTO personaldataresponse = new PersonalDataResponseDTO();
		PersonalDataDTO personaldatadto = new PersonalDataDTO();
		UserDTO userdto = new UserDTO();
		try {
			personaldatadto.setFirstname(personaldatarequest.getFirstname());	
			personaldatadto.setLastname(personaldatarequest.getLastname());
			personaldatadto.setFirstsurname(personaldatarequest.getFirstsurname());
			personaldatadto.setLastsurname(personaldatarequest.getLastsurname());
			userdto.setUsername(personaldatarequest.getUsername());
			userdto.setUserpassword(bcrypt.encode(personaldatarequest.getUserpassword()));
			personaldatadto.setUser(userdto);
			personaldatadto = logicpersona.save(personaldatadto);
			personaldataresponse = PersonalDataMapperResponse.INSTANCE.PersonalDataDTOToPersonalDataResponseDTO(personaldatadto);			
		}catch (ServiceException e) {
			throw new WebException(e.getMessage(), e.getCause() , e.getClazz());
		}
		return new ResponseEntity<>(personaldataresponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id_personar}")
	public ResponseEntity<?> modify (@RequestBody PersonalDataRequestDTO personaldatarequest, @PathVariable("id_personar") Integer id) throws WebException {
		logger.info("URL: /persona - PUT - Method modify // @RequestBody");
		PersonalDataResponseDTO personaldataresponse = new PersonalDataResponseDTO();
		PersonalDataDTO personaldatadto = new PersonalDataDTO();
		UserDTO userdto = new UserDTO();
		
		try {
			personaldatadto.setIdpersonaldata(id);
			personaldatadto.setFirstname(personaldatarequest.getFirstname());	
			personaldatadto.setLastname(personaldatarequest.getLastname());
			personaldatadto.setFirstsurname(personaldatarequest.getFirstsurname());
			personaldatadto.setLastsurname(personaldatarequest.getLastsurname());
			userdto.setUsername(personaldatarequest.getUsername());
			personaldatadto.setUser(userdto);
			personaldatadto = logicpersona.modificar(personaldatadto);
			personaldataresponse = PersonalDataMapperResponse.INSTANCE.PersonalDataDTOToPersonalDataResponseDTO(personaldatadto);	
			
		} catch (ServiceException e) {
			throw new WebException(e.getMessage(), e.getCause() , e.getClazz());
		}
		
		return new ResponseEntity<>(personaldataresponse, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Integer id) throws WebException {
		logger.info("URL: /persona - DELETE - Method delete");
		try {
			logicpersona.eliminar(id);
		} catch (ServiceException e) {
			throw new WebException(e.getMessage(), e.getCause() , e.getClazz());
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
