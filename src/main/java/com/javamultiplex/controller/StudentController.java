package com.javamultiplex.controller;

import com.javamultiplex.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohit Agarwal on 26/09/20 11:53 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Rohit Agarwal"),
            new Student(2, "Bhavna Agarwal"),
            new Student(3, "Shivani Agarwal")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Student "+studentId+" doesn't exist"));
    }
}
