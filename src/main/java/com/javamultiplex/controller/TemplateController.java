package com.javamultiplex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rohit Agarwal on 01/11/20 2:50 pm
 * @copyright www.javamultiplex.com
 */
@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("courses")
    public String getCoursesView() {
        return "courses";
    }

}
