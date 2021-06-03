/**
 * 
 */
package org.iot.business.model.logic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


/**
 * @author loboo
 *
 */
public class UserDTO {


	private Integer iduser;
	private String username;
	private String userpassword;
	private LocalDateTime created;
	private List<RoleDTO> rol;
	
	public UserDTO() {
		super();
	}

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public List<RoleDTO> getUserrol() {
		return rol;
	}

	public void setUserrol(List<RoleDTO> rol) {
		this.rol = rol;
	}
	
	

}
