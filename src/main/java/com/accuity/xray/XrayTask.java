package com.accuity.xray;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;

import java.io.IOException;
import java.util.Calendar;

public class XrayTask extends DefaultTask {
    public String url = "";
    public String user;
    public String password;

    @TaskAction
    public void runXray() {
        XrayReportProcessor processor = new XrayReportProcessor();
        System.out.println("Running tests at " + url);
        long startTime = Calendar.getInstance().getTimeInMillis();
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(user, password);
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
        HttpUriRequest request = new HttpGet(url);
        String json = null;
        try {
            HttpResponse httpResponse = client.execute(request);
            json = EntityUtils.toString(httpResponse.getEntity());
            if (json != null) {
                XrayReport report = processor.processXrayReport(json);
                long endTime = Calendar.getInstance().getTimeInMillis();
                System.out.println(report.getPassedTests() + "/" + report.getTotalTests() + " Xray tests passed in " + ((endTime - startTime) / 1000) + " seconds");
                if (!report.getErrors().isEmpty()) {
                    for (String failedTest : report.getErrors()) {
                        System.out.println(failedTest);
                    }
                    throw new TaskExecutionException(this, new RuntimeException("xray tests failed"));
                }
            } else {
                System.out.println("xray failed");
                throw new TaskExecutionException(this, new RuntimeException("xray failed"));
            }
        } catch (IOException e) {
            System.out.println("xray failed");
            throw new TaskExecutionException(this, e);
        }
    }

}