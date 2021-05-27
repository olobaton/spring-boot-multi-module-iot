/**
 * 
 */
package org.iot.business.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.iot.business.dataaccess.PersonalDataDao;
import org.iot.business.logic.LogicPersona;
import org.iot.business.model.dataaccess.PersonalDataPO;
import org.iot.business.model.dataaccess.UserPO;
import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.PersonalDataLogicDTO;

/**
 * @author loboo
 *
 */
@Service
public class LogicPersonaImpl implements LogicPersona {

	@Autowired
	private PersonalDataDao dataaccesspersona;

	@Override
	public List<PersonalDataLogicDTO> findAll() throws ServiceException {
		PersonalDataLogicDTO logicpersonapo = null;
		ArrayList<PersonalDataLogicDTO> list = null;
		list = new ArrayList<PersonalDataLogicDTO>();
		try {
			List<PersonalDataPO> listadata = dataaccesspersona.findAll();
			if (listadata.size() != 0) {
				for (PersonalDataPO obj : listadata) {
					logicpersonapo = new PersonalDataLogicDTO();
					logicpersonapo.setId(obj.getId());
					logicpersonapo.setNombre(obj.getNombre());
					logicpersonapo.setUsuario(obj.getUser().getUser());
					logicpersonapo.setPassword("Confidencial");
					list.add(logicpersonapo);
				}
			}

		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - finAll", e, LogicPersonaImpl.class);
		}
		return list;
	}

	@Override
	public PersonalDataLogicDTO save(PersonalDataLogicDTO p) throws ServiceException {
		PersonalDataPO datapersonapo = new PersonalDataPO();
		UserPO usuaripo = new UserPO();
		PersonalDataLogicDTO logicpersonapo = new PersonalDataLogicDTO();

		try {
			PersonalDataPO existingpersona = dataaccesspersona.findCustomByUserName(p.getUsuario());
			if (existingpersona == null) {
				usuaripo.setPassword(p.getPassword());
				usuaripo.setUser(p.getUsuario());
				datapersonapo.setUser(usuaripo);
				datapersonapo.setNombre(p.getNombre());
				datapersonapo = dataaccesspersona.saveAndFlush(datapersonapo);
				if (datapersonapo != null) {
					logicpersonapo.setId(datapersonapo.getId());
					logicpersonapo.setNombre(datapersonapo.getNombre());
					logicpersonapo.setUsuario(datapersonapo.getUser().getUser());
				}
			} else {
				throw new ElementAlreadyExistsException("User exists :" + p.getUsuario());
			}

		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error  - save", e.getMessage(), LogicPersonaImpl.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new ServiceException("return a unique result: 2  - save", e, LogicPersonaImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - save", e, LogicPersonaImpl.class);
		}
		return logicpersonapo;
	}

	@Override
	public PersonalDataLogicDTO modificar(PersonalDataLogicDTO p) throws ServiceException {

		PersonalDataPO datapersonapo = new PersonalDataPO();
		PersonalDataLogicDTO logicpersonadto = new PersonalDataLogicDTO();
		UserPO userpo;
		try {
			PersonalDataPO replicateduser = dataaccesspersona.findCustomByUserName(p.getUsuario());
			if (replicateduser == null) {
				PersonalDataPO existingpersona = dataaccesspersona.findCustomById(p.getId())
						.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + p.getId()));
				userpo = existingpersona.getUser();
				userpo.setUser(p.getUsuario());
				existingpersona.setNombre(p.getNombre());
				existingpersona.setUser(userpo);
				datapersonapo = dataaccesspersona.saveAndFlush(existingpersona);
				if (datapersonapo != null) {
					logicpersonadto.setId(datapersonapo.getId());
					logicpersonadto.setNombre(datapersonapo.getNombre());
					logicpersonadto.setUsuario(datapersonapo.getUser().getUser());
				}
			} else {
				throw new ElementAlreadyExistsException("User exists :" + p.getUsuario());
			}
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - modify", e.getMessage(), LogicPersonaImpl.class);
		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error - modify", e.getMessage(), LogicPersonaImpl.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new ServiceException("return a unique result: 2 - modify ", e, LogicPersonaImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - modify ", e, LogicPersonaImpl.class);
		}
		return logicpersonadto;
	}

	@Override
	public void eliminar(Integer id) throws ServiceException {
		try {
			PersonalDataPO existingpersona = dataaccesspersona.findCustomById(id)
					.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + id));
			dataaccesspersona.deleteById(existingpersona.getId());
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - delete", e.getMessage(), LogicPersonaImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - delete", e, LogicPersonaImpl.class);
		}
	}

}
