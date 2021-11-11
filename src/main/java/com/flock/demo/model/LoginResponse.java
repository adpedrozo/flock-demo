package com.flock.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flock.demo.model.credentials.CredentialsData;

public class LoginResponse {

    @JsonProperty("data")
    private CredentialsData data;

    @JsonProperty("errors")
    private ErrorData errors;

    @JsonCreator
    public LoginResponse(@JsonProperty("data") CredentialsData data,
                         @JsonProperty("errors") ErrorData errors) {
        this.data = data;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }

    public CredentialsData getData() {
        return data;
    }

    public void setData(CredentialsData data) {
        this.data = data;
    }

    public ErrorData getErrors() {
        return errors;
    }

    public void setErrors(ErrorData errors) {
        this.errors = errors;
    }
}
