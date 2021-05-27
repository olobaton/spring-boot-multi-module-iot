/**
 * 
 */
package org.iot.business.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author loboo
 *
 */
@Mapper
public interface PersonMapperBo {
	
	PersonMapperBo INSTANCE = Mappers.getMapper(PersonMapperBo.class);
	

}
