package com.web;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("view")
public class ElController implements Serializable {
    @Autowired
    TestService testService;
    int counter = 0;

    public String doSomething(Object o, Object o1, Object o2) {
        return this.getClass().getName() + " - " + testService.getMessage() + " " + o + " " + o1 + " " + o2 + " " + counter++;
    }
}
