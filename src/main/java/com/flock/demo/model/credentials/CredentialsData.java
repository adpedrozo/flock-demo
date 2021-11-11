package com.flock.demo.model.credentials;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsData {

    @JsonProperty("user")
    private String user;

    @JsonProperty("jwt")
    private String jwt;

    @JsonCreator
    public CredentialsData(@JsonProperty("user") String user,
                           @JsonProperty("jwt") String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "CredentialsData{" +
                "user='" + user + '\'' +
                ", jwt='" + jwt + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
