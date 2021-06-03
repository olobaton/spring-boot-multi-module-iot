/**
 * 
 */
package org.iot.business.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.iot.business.dataaccess.PersonalDataDao;
import org.iot.business.logic.PersonalDataBo;
import org.iot.business.logic.mapper.PersonMapperBo;
import org.iot.business.model.dataaccess.PersonalDataPO;
import org.iot.business.model.dataaccess.UserPO;
import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.PersonalDataDTO;

/**
 * @author loboo
 *
 */
@Service
public class PersonalDataBoImpl implements PersonalDataBo {

	@Autowired
	private PersonalDataDao dataaccesspersona;

	@Override
	public List<PersonalDataDTO> findAll() throws ServiceException {
		ArrayList<PersonalDataDTO> personaldatadto = new ArrayList<PersonalDataDTO>();
		try {
			List<PersonalDataPO> listadata = dataaccesspersona.getAllUsersAndRoles();
			if (listadata.size() != 0) {
				for (PersonalDataPO obj : listadata) {
					personaldatadto.add(PersonMapperBo.INSTANCE.PersonalDataPOtoPersonalDataDTO(obj));					
				}
			}

		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - finAll", e, PersonalDataBoImpl.class);
		}
		return personaldatadto;
	}

	@Override
	public PersonalDataDTO save(PersonalDataDTO personaldatadto) throws ServiceException {
		PersonalDataPO personaldatapo = new PersonalDataPO();
		UserPO userpo = new UserPO();

		try {
			PersonalDataPO existingpersona = dataaccesspersona.findCustomByUserName(personaldatadto.getUser().getUsername())
					.orElse(new PersonalDataPO());
			if (existingpersona.getIdpersonaldata() == null) {
				userpo.setUserpassword(personaldatadto.getUser().getUserpassword());
				userpo.setUsername(personaldatadto.getUser().getUsername());
				userpo.setCreated(new Date());
				personaldatapo.setUser(userpo);
				personaldatapo.setFirstname(personaldatadto.getFirstname());
				personaldatapo.setFirstsurname(personaldatadto.getFirstsurname());
				personaldatapo.setLastname(personaldatadto.getLastname());
				personaldatapo.setLastsurname(personaldatadto.getLastsurname());
				personaldatapo.setCreated(new Date());
				personaldatadto = 	PersonMapperBo.INSTANCE.PersonalDataPOtoPersonalDataDTO(dataaccesspersona.saveAndFlush(personaldatapo));			
			} else {
				throw new ElementAlreadyExistsException("User exists :" + personaldatadto.getUser().getUsername());
			}
		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error  - save", e.getMessage(), PersonalDataBoImpl.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new ServiceException("return a unique result: 2  - save", e, PersonalDataBoImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - save", e, PersonalDataBoImpl.class);
		}
		return personaldatadto;
	}

	@Override
	public PersonalDataDTO modificar(PersonalDataDTO personaldatadto) throws ServiceException {

		PersonalDataPO personaldatapo = null;
		UserPO userpo = null;
		PersonalDataDTO personaldatadtotemp = null;
		try {
			PersonalDataPO existingpersona = dataaccesspersona.findCustomByUserName(personaldatadto.getUser().getUsername())
					.orElse(new PersonalDataPO());
			if (existingpersona.getIdpersonaldata() == null) {
				PersonalDataPO finduser = dataaccesspersona.findCustomById(personaldatadto.getUser().getIduser())
						.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + personaldatadto.getUser().getIduser()));
				userpo = finduser.getUser();
				userpo.setUsername(personaldatadto.getUser().getUsername());
				finduser.setFirstname(personaldatadto.getFirstname());
				finduser.setUser(userpo);
				personaldatapo = dataaccesspersona.saveAndFlush(finduser);
				personaldatadtotemp = 	PersonMapperBo.INSTANCE.PersonalDataPOtoPersonalDataDTO(personaldatapo);
			} else {
				throw new ElementAlreadyExistsException("User exists :" + personaldatadto.getUser().getUsername());
			}
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - modify", e.getMessage(), PersonalDataBoImpl.class);
		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error - modify", e.getMessage(), PersonalDataBoImpl.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new ServiceException("return a unique result: 2 - modify ", e, PersonalDataBoImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - modify ", e, PersonalDataBoImpl.class);
		}
		return personaldatadtotemp;
	}

	@Override
	public void eliminar(Integer id) throws ServiceException {
		try {
			PersonalDataPO existingpersona = dataaccesspersona.findCustomById(id)
					.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + id));
			dataaccesspersona.deleteById(existingpersona.getIdpersonaldata());
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - delete", e.getMessage(), PersonalDataBoImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - delete", e, PersonalDataBoImpl.class);
		}
	}

}
