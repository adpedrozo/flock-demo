package com.flock.demo.controller;

import com.flock.demo.model.ErrorData;
import com.flock.demo.model.GetCoordinatesResponse;
import com.flock.demo.model.LoginRequest;
import com.flock.demo.model.LoginResponse;
import com.flock.demo.service.FlockDemoService;
import com.flock.demo.utils.InputSanitizer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/flock-demo")
public class FlockDemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(FlockDemoController.class);

    @Autowired
    private FlockDemoService flockDemoService;

    @ApiOperation(value = "Genera un Jason Web Token (JWT) en base a un usuario y contraseña válidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> getJWT(@Valid @RequestBody LoginRequest loginRequest){

        try {
            LOGGER.info("*** GET JWT For: {}", InputSanitizer.cleanInput(loginRequest.getUser()));
            return flockDemoService.getJWT(loginRequest);
        }
        catch (Exception e){
            LOGGER.error("*** Service Unavailable: {}", e.toString());
            ErrorData errorData = new ErrorData(503,"Service Unavailable", e.toString());
            LoginResponse errorResponse = new LoginResponse(null, errorData);
            return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @ApiOperation(value = "Retorna las coordinadas geográficas de una provincia Argentina, buscando por el nombre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 503, message = "Service Unavailable")
    })
    @GetMapping(value = "/get-coordinates", produces = "application/json")
    public ResponseEntity<GetCoordinatesResponse> getCoordinates(@RequestParam("provinceName") String provinceName) {

        try {
            LOGGER.info("*** GET Coordinates For: {}", InputSanitizer.cleanInput(provinceName));
            return flockDemoService.getCoordinates(provinceName);
        }
        catch (Exception e){
            LOGGER.error("*** Service Unavailable: {}", e.toString());
            ErrorData errorData = new ErrorData(503,"Service Unavailable", e.toString());
            GetCoordinatesResponse errorResponse = new GetCoordinatesResponse(null, errorData);
            return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

}
