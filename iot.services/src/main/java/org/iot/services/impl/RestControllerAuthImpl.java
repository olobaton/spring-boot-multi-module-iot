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

import io.jsonwebtoken.SignatureException;

import java.util.Objects;

import org.iot.services.RestControllerAuth;
import org.iot.services.config.jwt.JwtTokenUtil;
import org.iot.services.model.JwtResponse;
import org.iot.services.model.UserRequest;
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
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> auth (@RequestBody UserRequest p) throws Exception {
		String token = null;
		try {
			authenticate(p.getUsuario(), p.getPassword());
			final UserDetails user = userDetailsService.loadUserByUsername(p.getUsuario());
			token = jwtTokenUtil.generateToken(user);
			
		} catch (Exception e) {
			new Exception("uncontrolled error ", e);
		}		
		return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
	}
	
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
