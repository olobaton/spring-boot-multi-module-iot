/**
 * 
 */
package org.iot.business.model.util;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iot.business.model.dataaccess.PermissionsScopePO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapConverter implements AttributeConverter<PermissionsScopePO, String> {


	private static final Logger logger = LogManager.getLogger(HashMapConverter.class);
	
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(PermissionsScopePO customerInfo) {

        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return customerInfoJson;
    }

	@Override
    public PermissionsScopePO convertToEntityAttribute(String customerInfoJSON) {

    	PermissionsScopePO ppl2 = null;
		if (customerInfoJSON != null) {
			try {
				ppl2 = objectMapper.readValue(customerInfoJSON, PermissionsScopePO.class);
			} catch (IOException e) {
				logger.error("JSON reading error", e);
			}	         			
		}
		return ppl2;	
    }

}