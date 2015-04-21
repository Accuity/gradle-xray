package com.accuity.xray;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * Created by burnsj3 on 4/16/2015.
 */
public class XrayTest {
    String name;
    String result;
    String time;
    @JsonProperty("assert")
    List<XrayAssert> asserts;
    JsonNode error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<XrayAssert> getAsserts() {
        return asserts;
    }

    public void setAsserts(List<XrayAssert> asserts) {
        this.asserts = asserts;
    }

    public JsonNode getError() {
        return error;
    }

    public void setError(JsonNode error) {
        this.error = error;
    }
}
