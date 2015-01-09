package com.web;

import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Scope("request")
public class SpringMVCController implements Serializable {

    @Autowired
    TestService testService;

    @RequestMapping("/greeting")
    public String greeting() {
        return testService.getMessage() + "\n";
    }
}

