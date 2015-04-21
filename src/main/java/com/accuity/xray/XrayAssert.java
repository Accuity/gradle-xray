package com.accuity.xray;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by burnsj3 on 4/16/2015.
 */
public class XrayAssert {
    private String test;
    private String result;
    private JsonNode actual;
    private JsonNode expected;
    private String message;

    public void setActual(JsonNode actual) {
        this.actual = actual;
    }

    public JsonNode getActual() {
        return actual;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public JsonNode getExpected() {
        return expected;
    }

    public void setExpected(JsonNode expected) {
        this.expected = expected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "XrayAssert{" +
                "test='" + test + '\'' +
                ", result='" + result + '\'' +
                ", actual='" + actual.toString() + '\'' +
                ", expected='" + expected + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
