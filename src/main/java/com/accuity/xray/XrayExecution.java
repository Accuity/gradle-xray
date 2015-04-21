package com.accuity.xray;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by burnsj3 on 4/20/2015.
 */
public class XrayExecution {
    String dir;
    @JsonProperty("module-pattern")
    String modulePattern;
    @JsonProperty("test-pattern")
    String testPattern;
    @JsonProperty("xray-version")
    String xrayVersion;
    List<XrayModule> module;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getModulePattern() {
        return modulePattern;
    }

    public void setModulePattern(String modulePattern) {
        this.modulePattern = modulePattern;
    }

    public String getTestPattern() {
        return testPattern;
    }

    public void setTestPattern(String testPattern) {
        this.testPattern = testPattern;
    }

    public String getXrayVersion() {
        return xrayVersion;
    }

    public void setXrayVersion(String xrayVersion) {
        this.xrayVersion = xrayVersion;
    }

    public List<XrayModule> getModule() {
        return module;
    }

    public void setModule(List<XrayModule> module) {
        this.module = module;
    }
}
