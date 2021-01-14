package com.javamultiplex.controller;

import com.javamultiplex.model.JwtAuthenticationRequest;
import com.javamultiplex.model.JwtAuthenticationResponse;
import com.javamultiplex.service.JwtUserDetailService;
import com.javamultiplex.service.JwtService;
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
public class JwtAuthenticationController {

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public JwtAuthenticationResponse authentication(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(jwtAuthenticationRequest.getUsername(), jwtAuthenticationRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new RuntimeException("Invalid username or password");
        }

        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(jwtAuthenticationRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return new JwtAuthenticationResponse(token);
    }

}
