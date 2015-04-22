package com.accuity.xray;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * Created by burnsj3 on 4/16/2015.
 */
public class XrayModule {
    private String path;
    private int total;
    private int passed;
    private int ignored;
    private int failed;
    private JsonNode error;
    @JsonProperty("test")
    private List<XrayTest> tests;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getIgnored() {
        return ignored;
    }

    public void setIgnored(int ignored) {
        this.ignored = ignored;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public JsonNode getError() {
        return error;
    }

    public void setError(JsonNode error) {
        this.error = error;
    }

    public List<XrayTest> getTests() {
        return tests;
    }

    public void setTests(List<XrayTest> test) {
        this.tests = test;
    }
}
