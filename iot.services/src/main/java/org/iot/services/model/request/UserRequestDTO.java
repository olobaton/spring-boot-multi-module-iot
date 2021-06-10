package org.iot.services.model.request;

import java.time.LocalDateTime;
import java.util.Set;

import org.iot.services.util.LocalDateTimeDeserializer;
import org.iot.services.util.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UserRequestDTO {

	private Integer iduser;
	private String username;
	private String userpassword;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;
	
	private Set<UserRoleRequestDTO> userrole;

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

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Set<UserRoleRequestDTO> getUserrole() {
		return userrole;
	}

	public void setUserrole(Set<UserRoleRequestDTO> userrole) {
		this.userrole = userrole;
	}	
	
}
