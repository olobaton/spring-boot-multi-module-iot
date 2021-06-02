/**
 * 
 */
package org.iot.business.model.logic;

import java.time.LocalDateTime;


/**
 * @author loboo
 *
 */
public class PersonalDataDTO {
	
	private Integer idpersonaldata;	
	private String firstname;
	private String lastname;
	private String firstsurname;
	private String lastsurname;
	private LocalDateTime created;
	private UserDTO user;
	
	public PersonalDataDTO() {
		super();
	}
	
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}	
	

}
