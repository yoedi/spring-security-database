package com.authyd.springsecuritydb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping({"/hello"})
    public String printHello() {
        return "Hello World";
    }

}
