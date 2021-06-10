/**
 * 
 */
package org.iot.business.model.logic;

import java.time.LocalDateTime;

import org.iot.business.model.dataaccess.RolePO;
/**
 * @author loboo
 *
 */
public class RolePermissionDTO {

	private PermissionsScopeDTO scope;
	private LocalDateTime created;	
	private RolePO role;
	private PermissionPO permissions;
	
	public PermissionPO getPermissions() {
		return permissions;
	}

	public void setPermissions(PermissionPO permissions) {
		this.permissions = permissions;
	}

	public RolePermissionDTO() {
		super();
	}

	public PermissionsScopeDTO getScope() {
		return scope;
	}

	public void setScope(PermissionsScopeDTO scope) {
		this.scope = scope;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public RolePO getRole() {
		return role;
	}

	public void setRole(RolePO role) {
		this.role = role;
	}

}
