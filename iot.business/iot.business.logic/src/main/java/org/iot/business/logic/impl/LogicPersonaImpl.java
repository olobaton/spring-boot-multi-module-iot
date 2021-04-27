/**
 * 
 */
package org.iot.business.logic.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.iot.business.dataaccess.DataAccessPersona;
import org.iot.business.logic.LogicPersona;
import org.iot.business.model.dataaccess.DataPersonaPO;
import org.iot.business.model.dataaccess.UsuarioPO;
import org.iot.business.model.exception.ElementAlreadyExistsException;
import org.iot.business.model.exception.NoSuchElementFoundException;
import org.iot.business.model.logic.LogicPersonaDTO;

/**
 * @author loboo
 *
 */
@Component
public class LogicPersonaImpl implements LogicPersona {
	
	@Autowired
	private DataAccessPersona dataaccesspersona;
	
	ArrayList<LogicPersonaDTO> list = null;
	
	@Override
	public List<LogicPersonaDTO> findAll() {
		LogicPersonaDTO logicpersonapo = null;
		list = new ArrayList<LogicPersonaDTO>();
		List<DataPersonaPO> listadata= dataaccesspersona.findAll();
		if(listadata.size() != 0) {
			for (DataPersonaPO obj: listadata) {
				logicpersonapo = new LogicPersonaDTO();
				logicpersonapo.setId(obj.getId());
				logicpersonapo.setNombre(obj.getNombre());
				logicpersonapo.setUsuario(obj.getUsuario().getUsuario());
				logicpersonapo.setPassword("Confidencial");
				list.add(logicpersonapo);				
			}			
		}
		return list;
	}
	
	public LogicPersonaDTO save(LogicPersonaDTO p) throws Exception {
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
				if(datapersonapo != null) {			
					logicpersonapo.setId(datapersonapo.getId());
					logicpersonapo.setNombre(datapersonapo.getNombre());
					logicpersonapo.setUsuario(datapersonapo.getUsuario().getUsuario());
				}				
			} else  {
				throw new ElementAlreadyExistsException("User exists :" + p.getUsuario());
			}
			
		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error", e.getMessage());
		} catch (Exception e) {
			throw new Exception("uncontrolled error", e);
		}
		return logicpersonapo;
	}
	
	public LogicPersonaDTO modificar(LogicPersonaDTO p) throws Exception {
		
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
				if(datapersonapo != null) {			
					logicpersonadto.setId(datapersonapo.getId());
					logicpersonadto.setNombre(datapersonapo.getNombre());
					logicpersonadto.setUsuario(datapersonapo.getUsuario().getUsuario());
				}				
			} else {
				throw new ElementAlreadyExistsException("User exists :" + p.getUsuario());
			}	
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error", e.getMessage());
		} catch (ElementAlreadyExistsException e) {
			throw new ElementAlreadyExistsException("controlled error", e.getMessage());
		} catch (Exception e) {
			throw new Exception("uncontrolled error", e);
		}
		return logicpersonadto;
	}
	
	public void eliminar(Integer id) throws Exception {
		try {
			DataPersonaPO existingpersona = dataaccesspersona.findCustomById(id)
					.orElseThrow(() -> new NoSuchElementFoundException("No found id:" + id));
			dataaccesspersona.deleteById(existingpersona.getId());			
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error", e.getMessage());
		} catch (Exception e) {
			throw new Exception("uncontrolled error", e);
		}
	}

}
