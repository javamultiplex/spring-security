package com.javamultiplex.model;

import java.io.Serializable;

/**
 * @author Rohit Agarwal on 13/01/21 9:21 pm
 * @copyright www.javamultiplex.com
 */
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -7857706891351092313L;
    private String username;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
