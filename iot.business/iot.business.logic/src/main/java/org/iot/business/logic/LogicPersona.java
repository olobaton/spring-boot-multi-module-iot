/**
 * 
 */
package org.iot.business.logic;

import java.util.List;

import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.logic.LogicPersonaDTO;




/**
 * @author loboo
 *
 */
public interface LogicPersona {
	
	public List<LogicPersonaDTO> findAll();
	public LogicPersonaDTO save(LogicPersonaDTO p) throws Exception;
	public void eliminar(Integer id) throws Exception;
	public LogicPersonaDTO modificar(LogicPersonaDTO p) throws Exception;

}
