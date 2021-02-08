package com.authyd.springsecuritydb.controller;

import com.authyd.springsecuritydb.configuration.JwtUtil;
import com.authyd.springsecuritydb.model.LoginRequest;
import com.authyd.springsecuritydb.model.LoginResponse;
import com.authyd.springsecuritydb.model.User;
import com.authyd.springsecuritydb.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/loginA")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
            throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }

        User user = appUserService.loadUserByUsername(loginRequest.getUsername());
        String jwt = jwtUtil.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }

}
