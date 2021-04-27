/**
 * 
 */
package org.iot.services.model;

/**
 * @author loboo
 *
 */
public class PersonRequest {
	
	String nombre;
	String usuario;
	String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
