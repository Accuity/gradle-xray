# gradle-xray
A gradle plugin for running xray tests.

This plugin defines a task which will trigger xray tests via an HTTP request.  It parses the json response and prints out any failures to the console.  It is helpful for running xray tests as part of your integration test task.

example:

    task xrayAddn(type: XrayTask) {
        user = "user"
        password = "pass"
        url = "http://localhost:8003/xray/?dir=test&modules=&tests=&format=json"
    }
