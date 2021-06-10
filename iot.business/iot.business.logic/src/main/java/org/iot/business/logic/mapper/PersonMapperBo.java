/**
 * 
 */
package org.iot.business.logic.mapper;


import java.io.IOException;

import org.iot.business.model.dataaccess.PersonalDataPO;
import org.iot.business.model.logic.PermissionsScopeDTO;
import org.iot.business.model.logic.PersonalDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author loboo
 *
 */

@Mapper
public interface PersonMapperBo {

	PersonMapperBo INSTANCE = Mappers.getMapper(PersonMapperBo.class);	
	
	@Mappings({	})

	PersonalDataDTO PersonalDataPOtoPersonalDataDTO(PersonalDataPO personaldatapo);
	
	@Mappings({	})

	PersonalDataPO PersonalDataDTOToPersonalDataPO(PersonalDataDTO personaldatapo);
	

	/*
	 * @Named("convertDate") public static LocalDateTime convertObj(Date date)
	 * throws ServiceException { Date in = new Date(); LocalDateTime ldt =
	 * LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault()); return ldt;
	 * }
	 * 
	 * @Named("convertSet") public static Set<RoleDTO> convertObj(Set<UserRolePO>
	 * set) throws ServiceException { if (set == null) { return null; }
	 * 
	 * Set<RoleDTO> set1 = new HashSet<RoleDTO>(Math.max((int) (set.size() / .75f) +
	 * 1, 16)); for (UserRolePO userRolePO : set) {
	 * set1.add(userRolePOToRoleDTO(userRolePO)); }
	 * 
	 * return set1; }
	 * 
	 * static RoleDTO userRolePOToRoleDTO(UserRolePO userRolePO) { if ( userRolePO
	 * == null ) { return null; }
	 * 
	 * RoleDTO roleDTO = new RoleDTO();
	 * roleDTO.setIdrole(userRolePO.getRole().getIdrole());
	 * roleDTO.setRolename(userRolePO.getRole().getRolename()); if (
	 * userRolePO.getCreated() != null ) { roleDTO.setCreated(
	 * LocalDateTime.ofInstant( userRolePO.getRole().getCreated().toInstant(),
	 * ZoneId.of( "UTC" ) ) ); } return roleDTO; }
	 */

}
