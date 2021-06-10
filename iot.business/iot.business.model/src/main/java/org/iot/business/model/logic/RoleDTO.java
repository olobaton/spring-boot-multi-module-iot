/**
 * 
 */
package org.iot.business.model.logic;

import java.time.LocalDateTime;
import java.util.Set;


/**
 * @author loboo
 *
 */
public class RoleDTO {

	private Integer idrole;
	private String rolename;
	private LocalDateTime created;
	private Set<RolePermissionDTO> rolepermissions;
	
	public RoleDTO() {
		super();
	}

	public Integer getIdrole() {
		return idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Set<RolePermissionDTO> getRolepermissions() {
		return rolepermissions;
	}

	public void setRolepermissions(Set<RolePermissionDTO> rolepermissions) {
		this.rolepermissions = rolepermissions;
	}

}
