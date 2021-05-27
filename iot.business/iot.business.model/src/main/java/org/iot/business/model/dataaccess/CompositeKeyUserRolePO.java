/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author loboo
 *
 */
public class CompositeKeyUserRolePO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "fk_id_user", nullable = false)
	private int iduser;

	@Column(name = "fk_id_role", nullable = false)
	private int idrole;
	
	public CompositeKeyUserRolePO() {}

	public CompositeKeyUserRolePO(int iduser, int idrole) {
		super();
		this.iduser = iduser;
		this.idrole = idrole;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
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
		result = prime * result + idrole;
		result = prime * result + iduser;
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
		CompositeKeyUserRolePO other = (CompositeKeyUserRolePO) obj;
		if (idrole != other.idrole)
			return false;
		if (iduser != other.iduser)
			return false;
		return true;
	}

	
	

}
