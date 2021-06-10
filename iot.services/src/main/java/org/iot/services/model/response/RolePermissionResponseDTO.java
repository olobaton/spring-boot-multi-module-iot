/**
 * 
 */
package org.iot.services.model.response;

import java.time.LocalDateTime;

import org.iot.services.util.LocalDateTimeDeserializer;
import org.iot.services.util.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author loboo
 *
 */
public class RolePermissionResponseDTO {

	/**
	 * 
	 */
	private PermissionsScopeResponseDTO scope;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;
	
	private PermissionResponseDTO permissions;
	
	public PermissionsScopeResponseDTO getScope() {
		return scope;
	}
	public void setScope(PermissionsScopeResponseDTO scope) {
		this.scope = scope;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public PermissionResponseDTO getPermissions() {
		return permissions;
	}
	public void setPermissions(PermissionResponseDTO permissions) {
		this.permissions = permissions;
	}	
	
	

}
