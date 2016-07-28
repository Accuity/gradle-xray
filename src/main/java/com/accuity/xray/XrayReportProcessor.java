package com.accuity.xray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burnsj3 on 4/21/2015.
 */
public class XrayReportProcessor {


    public XrayReport processXrayReport(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        XrayReport xrayReport = new XrayReport();
        List<String> failedTests = new ArrayList<>();
        XrayWrapper xrayWrapper = mapper.readValue(json, XrayWrapper.class);
        XrayExecution xrayExecution = xrayWrapper.getTests();
        int totalTests = 0;
        int passedTests = 0;
        int ignoredTests = 0;
        for (XrayModule module : xrayExecution.getModule()) {
            int moduleTestsTotal = module.getTotal();
            int moduleTestsPassed = module.getPassed();
            int moduleTestsIgnored = module.getIgnored();
            totalTests += moduleTestsTotal;
            passedTests += moduleTestsPassed;
            ignoredTests += moduleTestsIgnored;
            if (moduleTestsPassed + moduleTestsIgnored != moduleTestsTotal) {
                if (module.getTests() != null) {
                    for (XrayTest test : module.getTests()) {
                        if (!test.getResult().equals("passed") && !test.getResult().equals("ignored")) {
                            if (test.getError() != null) {
                                failedTests.add(module.getPath() + " \t" + test.getName() + " \t" + test.getError().toString());
                            } else {
                                for (XrayAssert assertObj : test.getAsserts()) {
                                    if (!assertObj.getResult().equals("passed")) {
                                        failedTests.add(module.getPath() + " \t" + test.getName() + " \t" + assertObj.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        xrayReport.setErrors(failedTests);
        xrayReport.setTotalTests(totalTests);
        xrayReport.setPassedTests(passedTests);
        xrayReport.setIgnoredTests(ignoredTests);
        return xrayReport;
    }
}
