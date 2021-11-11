package com.flock.demo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flock.demo.model.provinces.ProvincesData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProvincesRepository {

    private static Logger LOGGER = LoggerFactory.getLogger(ProvincesRepository.class);

    public ProvincesData provincesDataMapping(String responseBody){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseBody,ProvincesData.class);
        }
        catch (Exception e){
            LOGGER.error("*** Provinces Data mapping errors: {}", e.toString());
            return null;
        }
    }
}
