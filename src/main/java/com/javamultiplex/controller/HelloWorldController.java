package com.javamultiplex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 13/01/21 9:11 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("/api/v1")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
