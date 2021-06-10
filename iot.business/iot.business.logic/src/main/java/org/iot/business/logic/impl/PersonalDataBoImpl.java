/**
 * 
 */
package org.iot.business.logic.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.iot.business.dataaccess.PersonalDataDao;
import org.iot.business.dataaccess.UserRoleDao;
import org.iot.business.logic.PersonalDataBo;
import org.iot.business.logic.mapper.PersonMapperBo;
import org.iot.business.model.dataaccess.CompositeKeyUserRolePO;
import org.iot.business.model.dataaccess.PersonalDataPO;
import org.iot.business.model.dataaccess.UserPO;
import org.iot.business.model.dataaccess.UserRolePO;
import org.iot.business.model.exception.BodyRequestException;
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
	private PersonalDataDao personaldatadao;
	
	@Autowired
	private UserRoleDao userrolepo;

	@Override
	public List<PersonalDataDTO> findAll() throws ServiceException {
		ArrayList<PersonalDataDTO> personaldatadto = new ArrayList<PersonalDataDTO>();
		try {
			List<PersonalDataPO> listadata = personaldatadao.getAllUsersAndRoles();
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

		Set<UserRolePO> userrolpo = new HashSet<UserRolePO>();
		UserPO userpo = new UserPO();
		try {
			PersonalDataPO existingpersona = personaldatadao.findCustomByUserName(personaldatadto.getUser().getUsername())
					.orElse(new PersonalDataPO());
			if (existingpersona.getIdpersonaldata() == null) {	
				existingpersona = personaldatadao.saveAndFlush(PersonMapperBo.INSTANCE.PersonalDataDTOToPersonalDataPO(personaldatadto));	
				userrolpo = completeUserRolePOSet(existingpersona.getUser());
				userrolpo = new HashSet<UserRolePO>(userrolepo.saveAll(userrolpo));
				userpo = existingpersona.getUser();
				userpo.setUserrole(userrolpo);
				existingpersona.setUser(userpo);
				personaldatadto = PersonMapperBo.INSTANCE.PersonalDataPOtoPersonalDataDTO(existingpersona);
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
			PersonalDataPO finduser = personaldatadao.findCustomById(personaldatadto.getIdpersonaldata())
					.orElseThrow(() -> new NoSuchElementFoundException("Id no found:" + personaldatadto.getIdpersonaldata()));
			PersonalDataPO existingpersona = personaldatadao.findCustomByUserName(personaldatadto.getUser().getUsername())
					.orElseThrow(() -> new BodyRequestException("Body error - Parameters no send "));
			if (existingpersona.getIdpersonaldata() == null) {				
				userpo = finduser.getUser();
				userpo.setUsername(personaldatadto.getUser().getUsername());
				finduser.setFirstname(personaldatadto.getFirstname());
				finduser.setUser(userpo);
				personaldatapo = personaldatadao.saveAndFlush(finduser);
				personaldatadtotemp = 	PersonMapperBo.INSTANCE.PersonalDataPOtoPersonalDataDTO(personaldatapo);
			} else {
				throw new ElementAlreadyExistsException("User exists :" + personaldatadto.getUser().getUsername());
			}
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - modify", e.getMessage(), PersonalDataBoImpl.class);
		} catch (BodyRequestException e) {
			throw new BodyRequestException("controlled error - modify", e.getMessage(), PersonalDataBoImpl.class);
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
			PersonalDataPO existingpersona = personaldatadao.findCustomById(id)
					.orElseThrow(() -> new NoSuchElementFoundException("Id no found:" + id));
			personaldatadao.deleteById(existingpersona.getIdpersonaldata());
		} catch (NoSuchElementFoundException e) {
			throw new NoSuchElementFoundException("controlled error - delete", e.getMessage(), PersonalDataBoImpl.class);
		} catch (Exception e) {
			throw new ServiceException("uncontrolled error - delete", e, PersonalDataBoImpl.class);
		}
	}
	
	protected Set<UserRolePO> completeUserRolePOSet(UserPO temp) {
        if ( temp == null ) {
            return null;
        }
        Set<UserRolePO> set = temp.getUserrole();
        Set<UserRolePO> set1 = new HashSet<UserRolePO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserRolePO userRolePO : set ) {
            set1.add( completeUserRolePO( userRolePO, temp ) );
        }

        return set1;
    }
	
	protected UserRolePO completeUserRolePO(UserRolePO temp, UserPO userpo) {
        if ( temp == null ) {
            return null;
        }

        CompositeKeyUserRolePO compositekey = new CompositeKeyUserRolePO();
        UserRolePO userrolpo = new UserRolePO();
        userrolpo = temp;
        
        compositekey.setIdrole(temp.getRole().getIdrole());
        compositekey.setIduser(userpo.getIduser());
        
        userrolpo.setUser(userpo);
        
        userrolpo.setIduserrol(compositekey);

        return userrolpo;
    }

}
