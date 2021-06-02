/**
 * 
 */
package org.iot.services.mapper;

import org.iot.business.model.logic.PersonalDataDTO;
import org.iot.services.model.response.PersonalDataResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author loboo
 *
 */
@Mapper
public interface PersonalDataMapperResponse {
	
	PersonalDataMapperResponse INSTANCE = Mappers.getMapper(PersonalDataMapperResponse.class);
	
	@Mappings({	})
	
	PersonalDataResponseDTO PersonalDataDTOToPersonalDataResponseDTO(PersonalDataDTO personaldatadto);

}
