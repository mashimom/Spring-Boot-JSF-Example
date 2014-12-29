package com.web;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Scope("view")
public class AjaxController implements Serializable {
    @Autowired
    TestService testService;

    int counter = 0;

    private String jsfTestString = "This string came from server side";

    public String doSomething(Object o, Object o1, Object o2) {
        return testService.getMessage() + " " + o + " " + o1 + " "+ o2 + " "+ counter++;
    }

    public void doSomething() {
        setJsfTestString(testService.getMessage() + " viewCounter=" + counter++);
    }

    public String getJsfTestString() {
        return jsfTestString;
    }

    public void setJsfTestString(String jsfTestString) {
        this.jsfTestString = jsfTestString;
    }
}
