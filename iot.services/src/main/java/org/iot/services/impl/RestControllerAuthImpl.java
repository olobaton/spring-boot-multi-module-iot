/**
 * 
 */
package org.iot.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.exception.WebException;
import org.iot.services.RestControllerAuth;
import org.iot.services.config.jwt.JwtTokenUtil;
import org.iot.services.model.request.UserRequestDTO;
import org.iot.services.model.response.JwtResponseDTO;
import org.iot.services.service.UserService;


/**
 * @author loboo
 *
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class RestControllerAuthImpl implements RestControllerAuth {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private static final Logger logger = LogManager.getLogger(RestControllerAuthImpl.class);
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> auth (@RequestBody UserRequestDTO userrequestdto) throws WebException {
		
		logger.info("URL: /auth - POST - Method auth // @RequestBody");
		
		String token = null;
		try {
			authenticate(userrequestdto.getUsername(), userrequestdto.getUserpassword());
			final UserDetails user = userDetailsService.loadUserByUsername(userrequestdto.getUsername());
			token = jwtTokenUtil.generateToken(user);
			
		} catch (ServiceException e) {
			throw new WebException(e.getMessage(), e.getCause() , e.getClazz());
		}		
		return new ResponseEntity<>(new JwtResponseDTO(token), HttpStatus.OK);
	}
	
	private void authenticate(String username, String password) throws ServiceException {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new ServiceException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new ServiceException("INVALID_CREDENTIALS", e);
		}
	}

}
