package com.accuity.xray;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by burnsj3 on 4/16/2015.
 */
public class XrayModule {
    String path;
    int total;
    int passed;
    int ignored;
    int failed;
    int error;
    @JsonProperty("test")
    List<XrayTest> tests;

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

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<XrayTest> getTests() {
        return tests;
    }

    public void setTests(List<XrayTest> test) {
        this.tests = test;
    }
}
