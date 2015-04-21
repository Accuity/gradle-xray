package com.accuity.xray;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by burnsj3 on 4/16/2015.
 */
public class XrayAssertTest {
    @Test
    public void testDeserialization() throws IOException {
        String test = "{\"test\":\"not-empty\", \"result\":\"passed\", \"actual\":{\"test\":{\"innerTest\":\"64\"}, \"test2\":\"1\"}, \"expected\":\"item()+\", \"message\":\"routingCode codeTypeAbbreviation not set\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        XrayAssert xrayAssert = objectMapper.readValue(test, XrayAssert.class);
        Assert.assertEquals("{\"test\":{\"innerTest\":\"64\"},\"test2\":\"1\"}", xrayAssert.getActual().toString());
    }
}