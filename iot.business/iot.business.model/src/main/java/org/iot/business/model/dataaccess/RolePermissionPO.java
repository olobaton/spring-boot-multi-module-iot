/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.iot.business.model.util.HashMapConverter;

/**
 * @author loboo
 *
 */
@Entity
@Table(name = "tbl_role_permissions")
public class RolePermissionPO {

	/**
	 * 
	 */

	@EmbeddedId
	private CompositeKeyRolePermissionPO idrolepermissions;

	@Convert(converter = HashMapConverter.class)
	@Column(name = "scope", nullable = false, columnDefinition = "TEXT")
	private PermissionsScopePO scope;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;

	@MapsId("idpermissions")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_permissions", referencedColumnName = "id_permissions")
	private PermissionPO permissions;

	@MapsId("idrole")
	@ManyToOne(fetch = FetchType.LAZY)	  
	@JoinColumn(name = "fk_id_role", referencedColumnName = "id_role") 
	private RolePO role;
	 

	public RolePermissionPO() {
		super();
	}


	public CompositeKeyRolePermissionPO getIdrolepermissions() {
		return idrolepermissions;
	}


	public void setIdrolepermissions(CompositeKeyRolePermissionPO idrolepermissions) {
		this.idrolepermissions = idrolepermissions;
	}


	public PermissionsScopePO getScope() {
		return scope;
	}


	public void setScope(PermissionsScopePO scope) {
		this.scope = scope;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public PermissionPO getPermissions() {
		return permissions;
	}


	public void setPermissions(PermissionPO permissions) {
		this.permissions = permissions;
	}


	public RolePO getRole() {
		return role;
	}


	public void setRole(RolePO rol) {
		this.role = rol;
	}

	

}
