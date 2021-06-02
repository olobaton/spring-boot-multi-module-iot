/**
 * 
 */
package org.iot.services.model.request;

import java.util.Date;

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
	private Integer iduser;
	private String username;
	private String userpassword;
	
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
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	

}
