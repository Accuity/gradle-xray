package com.accuity.xray;

import java.util.List;

/**
 * Created by burnsj3 on 4/20/2015.
 */
public class XrayReport {
    private int totalTests;
    private int passedTests;
    private int ignoredTests;
    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(int totalTests) {
        this.totalTests = totalTests;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public void setPassedTests(int passedTests) {
        this.passedTests = passedTests;
    }

    public int getIgnoredTests() {
        return ignoredTests;
    }

    public void setIgnoredTests(int ignoredTests) {
        this.ignoredTests = ignoredTests;
    }
}
