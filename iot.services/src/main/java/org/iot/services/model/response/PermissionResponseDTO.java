/**
 * 
 */
package org.iot.services.model.response;

/**
 * @author loboo
 *
 */
public class PermissionResponseDTO {
	
	private Integer idpermissions;
	private String permissionsname;
	private String permissionsdescription;
	
	public Integer getIdpermissions() {
		return idpermissions;
	}
	public void setIdpermissions(Integer idpermissions) {
		this.idpermissions = idpermissions;
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
	
	

}
