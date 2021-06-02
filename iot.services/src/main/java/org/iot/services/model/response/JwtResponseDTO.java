/**
 * 
 */
package org.iot.services.model.response;

import java.io.Serializable;

/**
 * @author loboo
 *
 */
public class JwtResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 678400515256919431L;
	private final String jwttoken;

	public JwtResponseDTO(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}