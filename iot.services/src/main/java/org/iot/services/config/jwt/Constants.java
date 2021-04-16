/**
 * 
 */
package org.iot.services.config.jwt;

/**
 * @author loboo
 *
 */
public enum Constants {
	
	LOGIN_URL ("/usuario"),
	HEADER_AUTHORIZACION_KEY ("Authorization"),
	TOKEN_BEARER_PREFIX ("Bearer "),
	
	SUPER_SECRET_KEY ("olobaton");

	private String id;
	
	private Constants(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
}
