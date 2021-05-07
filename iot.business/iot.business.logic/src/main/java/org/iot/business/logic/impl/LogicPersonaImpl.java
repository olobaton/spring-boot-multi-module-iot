/**
 * 
 */
package org.iot.business.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.iot.business.dataaccess.DataAccessPersona;
import org.iot.business.logic.LogicPersona;
import org.iot.business.model.dataaccess.DataPersonaPO;
import org.iot.business.model.dataaccess.UsuarioPO;
import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.LogicPersonaDTO;

/**
 * @author loboo
 *
 */
@Service
public class LogicPersonaImpl implements LogicPersona {

	@Autowired
	private DataAccessPersona dataaccesspersona;

	@Override
	public List<LogicPersonaDTO> findAll() throws ServiceException {
		LogicPersonaDTO logicpersonapo = null;
		ArrayList<LogicPersonaDTO> list = null;
		list = new ArrayList<LogicPersonaDTO>();
		try {
			List<DataPersonaPO> listadata = dataaccesspersona.findAll();
			if (listadata.size() != 0) {
				for (DataPersonaPO obj : listadata) {
					logicpersonapo = new LogicPersonaDTO();
					logicpersonapo.setId(obj.getId());
					logicpersonapo.setNombre(obj.getNombre());
					logicpersonapo.setUsuario(obj.getUsuario().getUsuario());
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
	public LogicPersonaDTO save(LogicPersonaDTO p) throws ServiceException {
		DataPersonaPO datapersonapo = new DataPersonaPO();
		UsuarioPO usuaripo = new UsuarioPO();
		LogicPersonaDTO logicpersonapo = new LogicPersonaDTO();

		try {
			DataPersonaPO existingpersona = dataaccesspersona.findCustomByUserName(p.getUsuario());
			if (existingpersona == null) {
				usuaripo.setPassword(p.getPassword());
				usuaripo.setUsuario(p.getUsuario());
				datapersonapo.setUsuario(usuaripo);
				datapersonapo.setNombre(p.getNombre());
				datapersonapo = dataaccesspersona.saveAndFlush(datapersonapo);
				if (datapersonapo != null) {
					logicpersonapo.setId(datapersonapo.getId());
					logicpersonapo.setNombre(datapersonapo.getNombre());
					logicpersonapo.setUsuario(datapersonapo.getUsuario().getUsuario());
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
	public LogicPersonaDTO modificar(LogicPersonaDTO p) throws ServiceException {

		DataPersonaPO datapersonapo = new DataPersonaPO();
		LogicPersonaDTO logicpersonadto = new LogicPersonaDTO();
		UsuarioPO userpo;
		try {
			DataPersonaPO replicateduser = dataaccesspersona.findCustomByUserName(p.getUsuario());
			if (replicateduser == null) {
				DataPersonaPO existingpersona = dataaccesspersona.findCustomById(p.getId())
						.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + p.getId()));
				userpo = existingpersona.getUsuario();
				userpo.setUsuario(p.getUsuario());
				existingpersona.setNombre(p.getNombre());
				existingpersona.setUsuario(userpo);
				datapersonapo = dataaccesspersona.saveAndFlush(existingpersona);
				if (datapersonapo != null) {
					logicpersonadto.setId(datapersonapo.getId());
					logicpersonadto.setNombre(datapersonapo.getNombre());
					logicpersonadto.setUsuario(datapersonapo.getUsuario().getUsuario());
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
			DataPersonaPO existingpersona = dataaccesspersona.findCustomById(id)
					.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + id));
			dataaccesspersona.deleteById(existingpersona.getId());
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - delete", e.getMessage(), LogicPersonaImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - delete", e, LogicPersonaImpl.class);
		}
	}

}
