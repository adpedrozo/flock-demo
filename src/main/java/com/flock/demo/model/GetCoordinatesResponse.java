package com.flock.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flock.demo.model.provinces.CoordinatesData;

public class GetCoordinatesResponse {

    @JsonProperty("data")
    private CoordinatesData data;

    @JsonProperty("errors")
    private ErrorData errors;

    @JsonCreator
    public GetCoordinatesResponse(@JsonProperty("data") CoordinatesData data,
                                  @JsonProperty("errors") ErrorData errors) {
        this.data = data;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "GetCoordinatesResponse{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }

    public CoordinatesData getData() {
        return data;
    }

    public void setData(CoordinatesData data) {
        this.data = data;
    }

    public ErrorData getErrors() {
        return errors;
    }

    public void setErrors(ErrorData errors) {
        this.errors = errors;
    }
}
