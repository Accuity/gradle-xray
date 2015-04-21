package com.accuity.xray;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Created by burnsj3 on 4/15/2015.
 */
public class RunXray implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("xray", XrayTask.class);

    }
}
