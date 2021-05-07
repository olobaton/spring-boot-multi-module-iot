/**
 * 
 */
package org.iot.business.logic;

import java.util.List;

import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.LogicPersonaDTO;
import org.springframework.stereotype.Service;




/**
 * @author loboo
 *
 */
@Service
public interface LogicPersona {
	
	public List<LogicPersonaDTO> findAll() throws ServiceException;
	public LogicPersonaDTO save(LogicPersonaDTO p) throws ServiceException;
	public void eliminar(Integer id) throws ServiceException;
	public LogicPersonaDTO modificar(LogicPersonaDTO p) throws ServiceException;

}
