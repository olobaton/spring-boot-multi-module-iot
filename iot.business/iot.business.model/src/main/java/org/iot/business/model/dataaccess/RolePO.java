/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * @author loboo
 *
 */
@Entity
@Table(name = "tbl_roles")
public class RolePO {

	/**
	 * 
	 */

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id_role")
	private Integer idrole;

	@Column(name = "role_name", nullable = false, length = 50)
	private String rolename;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;

	@OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) 
	private	Set<RolePermissionPO> rolepermissions;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) 
	private	Set<UserRolePO> userrol = new HashSet<>();
	 

	public RolePO() {
		super();
	}

	public RolePO(Integer idrole, String rolename, Date created, Set<RolePermissionPO> rolepermissions,
			Set<UserRolePO> userrol) {
		super();
		this.idrole = idrole;
		this.rolename = rolename;
		this.created = created;
		this.rolepermissions = rolepermissions;
		this.userrol = userrol;
	}

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


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Set<RolePermissionPO> getRolepermissions() {
		return rolepermissions;
	}


	public void setRolepermissions(Set<RolePermissionPO> rolepermissionspo) {
		this.rolepermissions = rolepermissionspo;
	}


	public Set<UserRolePO> getUserrol() {
		return userrol;
	}


	public void setUserrol(Set<UserRolePO> userrol) {
		this.userrol = userrol;
	}


}
