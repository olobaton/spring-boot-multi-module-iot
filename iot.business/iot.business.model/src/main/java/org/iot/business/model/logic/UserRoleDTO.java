/**
 * 
 */
package org.iot.business.model.logic;

import java.time.LocalDateTime;

/**
 * @author loboo
 *
 */
public class UserRoleDTO {

	/**
	 * 
	 */
	private LocalDateTime created;	
	private RoleDTO role;
	
	public UserRoleDTO() {
		super();
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
}
