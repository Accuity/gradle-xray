package com.accuity.xray;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by burnsj3 on 4/20/2015.
 */
public class XrayExecutionTest {
    public void testDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String test = "{" +
                "   \"tests\": {" +
                "       \"dir\": \"v2.5.0/test/addn\", " +
                "       \"module-pattern\": \"\", " +
                "       \"test-pattern\": \"\", " +
                "       \"xray-version\": \"2.0\"," +
                "       \"module\": []" +
                "   } " +
                "}";
        XrayExecution xrayExecution = mapper.readValue(test, XrayExecution.class);
        Assert.assertEquals("v2.5.0/test/addn", xrayExecution.getDir());
        Assert.assertEquals(0, xrayExecution.getModule().size());
    }

}