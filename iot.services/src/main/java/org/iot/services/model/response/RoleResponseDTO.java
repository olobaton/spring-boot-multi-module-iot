/**
 * 
 */
package org.iot.services.model.response;

import java.time.LocalDateTime;
import java.util.Set;

import org.iot.services.util.LocalDateTimeDeserializer;
import org.iot.services.util.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author loboo
 *
 */
public class RoleResponseDTO {

	private Integer idrole;
	private String rolename;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;

	private Set<RolePermissionResponseDTO> rolepermissions;

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

	public Set<RolePermissionResponseDTO> getRolepermissions() {
		return rolepermissions;
	}

	public void setRolepermissions(Set<RolePermissionResponseDTO> rolepermission) {
		this.rolepermissions = rolepermission;
	}
	
	
}
