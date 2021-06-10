/**
 * 
 */
package org.iot.services.model.request;

/**
 * @author loboo
 *
 */
public class RoleRequestDTO {
	
	private Integer idrole;
	private String rolename;
	
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
}
