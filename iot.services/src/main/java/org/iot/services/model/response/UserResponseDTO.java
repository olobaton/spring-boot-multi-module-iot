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
public class UserResponseDTO {
	
	private Integer iduser;
	private String username;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;
	
	private Set<UserRoleReponseDTO> userrole;
	
	
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
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public Set<UserRoleReponseDTO> getUserrole() {
		return userrole;
	}
	public void setUserrole(Set<UserRoleReponseDTO> userrole) {
		this.userrole = userrole;
	}
}
