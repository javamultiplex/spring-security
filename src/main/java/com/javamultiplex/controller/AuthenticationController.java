package com.javamultiplex.controller;

import com.javamultiplex.model.AuthenticationRequest;
import com.javamultiplex.model.AuthenticationResponse;
import com.javamultiplex.service.CustomUserDetailService;
import com.javamultiplex.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 13/01/21 9:25 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authentication(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new RuntimeException("Invalid username or password");
        }

        UserDetails userDetails = customUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }

}
