/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author loboo
 *
 */
@Embeddable
public class CompositeKeyRolePermissionPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "fk_id_permissions", nullable = false)
	private int idpermissions;

	@Column(name = "fk_id_role", nullable = false)
	private int idrole;
	
	public CompositeKeyRolePermissionPO() {
		super();
	}	

	public CompositeKeyRolePermissionPO(int idpermissions, int idrole) {
		super();
		this.idpermissions = idpermissions;
		this.idrole = idrole;
	}

	public int getIdpermissions() {
		return idpermissions;
	}

	public void setIdpermissions(int idpermissions) {
		this.idpermissions = idpermissions;
	}

	public int getIdrole() {
		return idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpermissions;
		result = prime * result + idrole;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKeyRolePermissionPO other = (CompositeKeyRolePermissionPO) obj;
		if (idpermissions != other.idpermissions)
			return false;
		if (idrole != other.idrole)
			return false;
		return true;
	}
	
	
}
