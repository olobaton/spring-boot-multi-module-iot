/**
 * 
 */
package org.iot.services.service;

import java.util.ArrayList;
import java.util.List;

import org.iot.business.dataaccess.UserDao;
import org.iot.business.model.dataaccess.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author loboo
 *
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPO response = user.findByUser(username);
		if (response == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDet = new User(response.getUsername(),response.getUserpassword(), roles);
		return userDet;
	}

}
