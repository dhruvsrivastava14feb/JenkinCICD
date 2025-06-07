package com.cicd.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jkncicd")
public class JenkinTestController {

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "Welcome to Jenkins CICD tutorials";
    }
}
