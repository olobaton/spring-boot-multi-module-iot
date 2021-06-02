/**
 * 
 */
package org.iot.business.logic;

import java.util.List;

import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.PersonalDataDTO;
import org.springframework.stereotype.Service;




/**
 * @author loboo
 *
 */
@Service
public interface PersonalDataBo {
	
	public List<PersonalDataDTO> findAll() throws ServiceException;
	public PersonalDataDTO save(PersonalDataDTO p) throws ServiceException;
	public void eliminar(Integer id) throws ServiceException;
	public PersonalDataDTO modificar(PersonalDataDTO p) throws ServiceException;

}
