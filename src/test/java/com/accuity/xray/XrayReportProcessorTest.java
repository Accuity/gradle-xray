package com.accuity.xray;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burnsj3 on 4/21/2015.
 */
public class XrayReportProcessorTest {

    @Test
    public void testProcessXrayReport() throws Exception {
        XrayReportProcessor xrayTask = new XrayReportProcessor();

        ObjectMapper mapper = new ObjectMapper();
        XrayExecution execution = new XrayExecution();
        List<XrayModule> modules = new ArrayList<>();
        XrayModule module1 = new XrayModule();
        module1.setPassed(5);
        module1.setTotal(5);
        modules.add(module1);
        XrayModule module2 = new XrayModule();
        module2.setPassed(3);
        module2.setTotal(5);
        modules.add(module2);
        execution.setModule(modules);
        String json = "{\"tests\": " + mapper.writeValueAsString(execution) + "}";
        XrayReport report = xrayTask.processXrayReport(json);
        Assert.assertEquals(report.getTotalTests(), 10);
        Assert.assertEquals(report.getPassedTests(), 8);

    }
}