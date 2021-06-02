/**
 * 
 */
package org.iot.business.logic.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.iot.business.model.dataaccess.PersonalDataPO;
import org.iot.business.model.exception.ServiceException;
import org.iot.business.model.logic.PersonalDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author loboo
 *
 */
@Mapper
public interface PersonMapperBo {
	
	PersonMapperBo INSTANCE = Mappers.getMapper(PersonMapperBo.class);
	
	@Mappings({
		@Mapping(source = "created", target="created", qualifiedByName = "convertDate"),
		@Mapping(source = "user.created", target="user.created", qualifiedByName = "convertDate")
	})	

	PersonalDataDTO PersonalDataPOtoPersonalDataDTO(PersonalDataPO personaldatapo);
	
	@Named("convertDate") 
    public static LocalDateTime convertObj(Date date) throws ServiceException {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());	
		return ldt;
    }
	
}
