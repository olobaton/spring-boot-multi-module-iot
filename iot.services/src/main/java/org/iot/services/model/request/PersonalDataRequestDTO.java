/**
 * 
 */
package org.iot.services.model.request;

import java.time.LocalDateTime;

import org.iot.services.util.LocalDateTimeDeserializer;
import org.iot.services.util.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author loboo
 *
 */
public class PersonalDataRequestDTO {
	
	private Integer idpersonaldata;	
	private String firstname;
	private String lastname;
	private String firstsurname;
	private String lastsurname;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)  
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime created;
  
	private UserRequestDTO user;

	public Integer getIdpersonaldata() {
		return idpersonaldata;
	}

	public void setIdpersonaldata(Integer idpersonaldata) {
		this.idpersonaldata = idpersonaldata;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstsurname() {
		return firstsurname;
	}

	public void setFirstsurname(String firstsurname) {
		this.firstsurname = firstsurname;
	}

	public String getLastsurname() {
		return lastsurname;
	}

	public void setLastsurname(String lastsurname) {
		this.lastsurname = lastsurname;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public UserRequestDTO getUser() {
		return user;
	}

	public void setUser(UserRequestDTO user) {
		this.user = user;
	}

}
