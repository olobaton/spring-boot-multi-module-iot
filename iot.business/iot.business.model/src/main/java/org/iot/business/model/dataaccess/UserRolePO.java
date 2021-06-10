/**
 * 
 */
package org.iot.business.model.dataaccess;

import java.util.Date;

import javax.persistence.Column;
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

/**
 * @author loboo
 *
 */
@Entity
@Table(name = "tbl_user_rol")
public class UserRolePO {

	/**
	 * 
	 */
	@EmbeddedId
	private CompositeKeyUserRolePO iduserrol;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;
	
	@MapsId("iduser")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
	private UserPO user;
	
	@MapsId("idrole")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_role", referencedColumnName = "id_role")
	private RolePO role;

	public UserRolePO() {
		super();
	}

	public CompositeKeyUserRolePO getIduserrol() {
		return iduserrol;
	}

	public void setIduserrol(CompositeKeyUserRolePO iduserrol) {
		this.iduserrol = iduserrol;
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

	public RolePO getRole() {
		return role;
	}

	public void setRole(RolePO role) {
		this.role = role;
	}

}
