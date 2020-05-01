package com.example.SmartbeeExam1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/super/hello")
    public String super_() {
        return "hello super";
    }

    @RequestMapping("/manager/hello")
    public String manager() {
        return "hello manager";
    }

    @RequestMapping("/operator/hello")
    public String operator() {
        return "hello operator";
    }
}
