package com.flock.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    @JsonProperty("user")
    private String user;

    @JsonProperty("password")
    private String password;

    @JsonCreator
    public LoginRequest(@JsonProperty("user") String user,
                        @JsonProperty("password") String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
