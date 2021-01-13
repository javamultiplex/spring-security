package com.javamultiplex.model;

import java.io.Serializable;

/**
 * @author Rohit Agarwal on 13/01/21 9:24 pm
 * @copyright www.javamultiplex.com
 */
public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 8947182242279888334L;
    private String jwt;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
