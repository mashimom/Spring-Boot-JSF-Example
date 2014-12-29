package com.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Scope("session")
public class TestService implements Serializable {
    private int counter = 0;

    public String getMessage() {
        return "Example message - sessionCounter=" + counter++;
    }
}
