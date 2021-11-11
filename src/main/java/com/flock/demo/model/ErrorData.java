package com.flock.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorData {

    @JsonProperty("statusCode")
    private Integer statusCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("trace")
    private String trace;

    @JsonCreator
    public ErrorData(@JsonProperty("statusCode") Integer statusCode,
                     @JsonProperty("message") String message,
                     @JsonProperty("trace") String trace) {
        this.statusCode = statusCode;
        this.message = message;
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "ErrorData{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", trace='" + trace + '\'' +
                '}';
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
