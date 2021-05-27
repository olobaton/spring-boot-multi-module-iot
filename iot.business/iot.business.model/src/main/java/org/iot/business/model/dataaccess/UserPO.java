/**
 * 
 */
package org.iot.business.model.dataaccess;

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
	private Integer id;
	
	@Column(name="user_name", nullable = false, length = 50)
	private String user;
	
	@Column(name="password", nullable = false, columnDefinition="TEXT")
	private String password;
	
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PersonalDataPO persona;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserRolePO> userrol;
	
	public UserPO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PersonalDataPO getPersona() {
		return persona;
	}
	public void setPersona(PersonalDataPO persona) {
		this.persona = persona;
	}
	public Set<UserRolePO> getUserrol() {
		return userrol;
	}
	public void setUserrol(Set<UserRolePO> userrol) {
		this.userrol = userrol;
	}
}
