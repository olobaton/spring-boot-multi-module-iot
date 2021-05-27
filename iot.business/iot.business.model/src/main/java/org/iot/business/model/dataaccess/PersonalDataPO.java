/**
 * 
 */
package org.iot.business.model.dataaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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
	private Integer id;	
	
	@Column(name="nombre", nullable = false, length = 50)
	private String nombre;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
	private UserPO user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UserPO getUser() {
		return user;
	}
	public void setUser(UserPO user) {
		this.user = user;
	}
	
}
