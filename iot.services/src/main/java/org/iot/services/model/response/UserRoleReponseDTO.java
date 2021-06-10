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
public class UserRoleReponseDTO {
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;	
	
	private RoleResponseDTO role;
	
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public RoleResponseDTO getRole() {
		return role;
	}
	public void setRole(RoleResponseDTO role) {
		this.role = role;
	}
	
	

}
