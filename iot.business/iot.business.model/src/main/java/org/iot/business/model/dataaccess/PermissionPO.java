/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author loboo
 *
 */
@Entity
@Table(name = "tbl_permissions")
public class PermissionPO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id_permissions")
	private Integer idpermissions;

	@Column(name = "permissions_name", nullable = false, length = 50)
	private String permissionsname;

	@Column(name = "permissions_description", nullable = false, length = 250)
	private String permissionsdescription;

	@OneToMany(mappedBy = "permissions", fetch = FetchType.EAGER)
	private Set<RolePermissionPO> rolepermissionspo;

	public Integer getIdpermissions() {
		return idpermissions;
	}

	public String getPermissionsname() {
		return permissionsname;
	}

	public void setPermissionsname(String permissionsname) {
		this.permissionsname = permissionsname;
	}

	public String getPermissionsdescription() {
		return permissionsdescription;
	}

	public void setPermissionsdescription(String permissionsdescription) {
		this.permissionsdescription = permissionsdescription;
	}

	public void setIdpermissions(Integer idpermissions) {
		this.idpermissions = idpermissions;
	}

	public Set<RolePermissionPO> getRolepermissionspo() {
		return rolepermissionspo;
	}

	public void setRolepermissionspo(Set<RolePermissionPO> rolepermissionspo) {
		this.rolepermissionspo = rolepermissionspo;
	}
}
