/**
 * 
 */
package org.iot.business.model.logic;

/**
 * @author loboo
 *
 */
public class PermissionsScopeDTO {

	/**
	 * 
	 */
	
	private Boolean get;
	private Boolean modify;
	private Boolean delete;
	private Boolean create;
	
	public PermissionsScopeDTO() {
		super();
	}

	public Boolean getGet() {
		return get;
	}

	public void setGet(Boolean get) {
		this.get = get;
	}

	public Boolean getModify() {
		return modify;
	}

	public void setModify(Boolean modify) {
		this.modify = modify;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Boolean getCreate() {
		return create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}
	
	

}
