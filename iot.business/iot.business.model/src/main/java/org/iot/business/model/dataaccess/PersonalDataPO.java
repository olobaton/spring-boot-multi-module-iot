/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


/**
 * @author loboo
 *
 */

@Entity
@Table(name = "tbl_personal_data")
public class PersonalDataPO {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id_personal_data")
	private Integer idpersonaldata;	
	
	@Column(name="first_name", nullable = false, length = 50)
	private String firstname;
	
	@Column(name="last_name", nullable = false, length = 50)
	private String lastname;
	
	@Column(name="first_surname", nullable = false, length = 50)
	private String firstsurname;
	
	@Column(name="last_surname", nullable = false, length = 50)
	private String lastsurname;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
	private UserPO user;

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}	
	
}
