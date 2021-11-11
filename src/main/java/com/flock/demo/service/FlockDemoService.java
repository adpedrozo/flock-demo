package com.flock.demo.service;

import com.flock.demo.model.LoginRequest;
import com.flock.demo.model.LoginResponse;
import com.flock.demo.model.credentials.CredentialsData;
import com.flock.demo.model.provinces.CoordinatesData;
import com.flock.demo.model.ErrorData;
import com.flock.demo.model.GetCoordinatesResponse;
import com.flock.demo.model.provinces.ProvincesData;
import com.flock.demo.repository.ProvincesRepository;
import com.flock.demo.utils.DataUtils;
import com.flock.demo.utils.HttpClient;
import com.flock.demo.utils.InputSanitizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class FlockDemoService {

    private static Logger LOGGER = LoggerFactory.getLogger(FlockDemoService.class);

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private DataUtils dataUtils;

    @Autowired
    private ProvincesRepository provincesRepository;

    public ResponseEntity<LoginResponse> getJWT(LoginRequest loginRequest){

        boolean isValid = dataUtils.validateUser(loginRequest);
        LOGGER.info("*** {} credentials result: {}", InputSanitizer.cleanInput(loginRequest.getUser()), isValid);
        if (isValid){
            String jwt = dataUtils.createJWT(loginRequest.getUser(), loginRequest.getPassword());
            LOGGER.info("*** jwt: {}", jwt);
            CredentialsData credentialsData = new CredentialsData(loginRequest.getUser(),jwt);
            LoginResponse okResponse =  new LoginResponse(credentialsData, null);
            LOGGER.info("*** Response: {}", okResponse.toString());
            return new ResponseEntity<>(okResponse,HttpStatus.OK);
        }
        else {
            ErrorData errorData = new ErrorData(400,
                    "invalid authentication for: " + loginRequest.getUser(),
                    null);
            LoginResponse errorResponse = new LoginResponse(null, errorData);
            LOGGER.info("*** Response: {}", errorResponse.toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<GetCoordinatesResponse> getCoordinates(String provinceName){

        String responseData = httpClient.getProvincesData();
        LOGGER.info("*** Public API response: {}", InputSanitizer.cleanInput(responseData));

        ProvincesData provincesData = provincesRepository.provincesDataMapping(responseData);
        CoordinatesData coordinatesData = dataUtils.getCoordinatesByName(provincesData,provinceName);
        LOGGER.info("*** Coordinates Data: {}", InputSanitizer.cleanInput(coordinatesData.toString()));

        if ( coordinatesData.getProvinceName() != null ){
            GetCoordinatesResponse okResponse = new GetCoordinatesResponse(coordinatesData,null);
            LOGGER.info("*** Response: {}", okResponse.toString());
            return new ResponseEntity<>(okResponse,HttpStatus.OK);
        }
        else {
            ErrorData errorData = new ErrorData(404,
                    "no search results were found for: " + provinceName,
                    null);
            GetCoordinatesResponse emptyResponse = new GetCoordinatesResponse(null, errorData);
            LOGGER.info("*** Response: {}", emptyResponse.toString());
            return new ResponseEntity<>(emptyResponse, HttpStatus.NOT_FOUND);
        }
    }
}
