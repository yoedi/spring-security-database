package com.authyd.springsecuritydb.controller;

import com.authyd.springsecuritydb.model.User;
import com.authyd.springsecuritydb.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return appUserService.save(user);
    }

}
