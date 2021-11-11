package com.flock.demo.service;

import com.flock.demo.model.LoginRequest;
import com.flock.demo.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlockDemoServiceTest {

    @Mock
    private DataUtils dataUtils;

    @InjectMocks
    private FlockDemoService flockDemoService;

    private LoginRequest loginRequest;

    private String jwt;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loginRequest = new LoginRequest("flock","password-test");
        jwt = "jwt-test";
    }

    @Test
    void getValidCredentials() {
        when(dataUtils.validateUser(loginRequest)).thenReturn(true);
        when(dataUtils.createJWT(loginRequest.getUser(),loginRequest.getPassword())).thenReturn(jwt);
        assertNotNull(flockDemoService.getJWT(loginRequest));
    }

    @Test
    void getInvalidCredentials() {
        when(dataUtils.validateUser(loginRequest)).thenReturn(false);
        assertNotNull(flockDemoService.getJWT(loginRequest));
    }
}