/**
 * 
 */
package org.iot.business.logic;

import java.util.List;

import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.PersonalDataLogicDTO;
import org.springframework.stereotype.Service;




/**
 * @author loboo
 *
 */
@Service
public interface LogicPersona {
	
	public List<PersonalDataLogicDTO> findAll() throws ServiceException;
	public PersonalDataLogicDTO save(PersonalDataLogicDTO p) throws ServiceException;
	public void eliminar(Integer id) throws ServiceException;
	public PersonalDataLogicDTO modificar(PersonalDataLogicDTO p) throws ServiceException;

}
