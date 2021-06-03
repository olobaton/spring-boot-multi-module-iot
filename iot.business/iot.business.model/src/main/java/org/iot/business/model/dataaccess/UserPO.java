/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name= "tbl_user")
public class UserPO {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id_user")
	private Integer iduser;
	
	@Column(name="user_name", nullable = false, length = 50)
	private String username;
	
	@Column(name="user_password", nullable = false, columnDefinition="TEXT")
	private String userpassword;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;
	
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PersonalDataPO person;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserRolePO> userrol = new HashSet<>();

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public PersonalDataPO getPerson() {
		return person;
	}

	public void setPerson(PersonalDataPO person) {
		this.person = person;
	}

	public Set<UserRolePO> getUserrol() {
		return userrol;
	}

	public void setUserrol(Set<UserRolePO> userrol) {
		this.userrol = userrol;
	}
	
	
	
}
